package ulbra.saolucas.apphamburgueria;



import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button btnentrar, btncriarconta;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialização dos elementos da interface
        editTextEmail = findViewById(R.id.edemail);
        editTextPassword = findViewById(R.id.edsenha);
        btnentrar = findViewById(R.id.btentrar);
        btncriarconta = findViewById(R.id.btcriconta);
        // Inicialização do banco de dados SQLite
        database = openOrCreateDatabase("AppBurgerDB", MODE_PRIVATE, null);
        createDatabaseTables();

        // Configuração do botão de login
        btnentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (checkLogin(email, password)) {
                    // Login bem-sucedido, redireciona para a tela do catálogo
                    Intent intent = new Intent(MainActivity.this, CatalogActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "E-mail ou senha incorretos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configuração do botão para criar uma conta
        btncriarconta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    // Método para verificar o login
    private boolean checkLogin(String email, String password) {
        Cursor cursor = database.rawQuery("SELECT * FROM User WHERE email = ? AND password = ?", new String[]{email, password});
        boolean loginSuccess = cursor.getCount() > 0;
        cursor.close();
        return loginSuccess;
    }

    // Método para criar as tabelas do banco de dados
    private void createDatabaseTables() {
        // Criação da tabela de usuários
        String userTable = "CREATE TABLE IF NOT EXISTS User (" +
                "user_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "email TEXT," +
                "password TEXT," +
                "telephone TEXT);";
        database.execSQL(userTable);

        // Criação da tabela de produtos
        String productTable = "CREATE TABLE IF NOT EXISTS Product (" +
                "product_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "product_name TEXT," +
                "description TEXT," +
                "price REAL," +
                "category TEXT);";
        database.execSQL(productTable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Fecha o banco de dados ao destruir a atividade
        if (database != null && database.isOpen()) {
            database.close();
        }
    }
}

package ulbra.saolucas.apphamburgueria;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import ulbra.saolucas.apphamburgueria.DatabaseHelper;
import ulbra.saolucas.apphamburgueria.LoginActivity;
import ulbra.saolucas.apphamburgueria.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtNome, edtEmail, edtSenha, edtTelefone;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        edtNome = findViewById(R.id.edtnome);
        edtEmail = findViewById(R.id.edtemail);
        edtSenha = findViewById(R.id.edtsenha);
        edtTelefone = findViewById(R.id.edttelefone);
        Button btnCadastrar = findViewById(R.id.btcadastrar);

        dbHelper = new DatabaseHelper(this);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();
        String telefone = edtTelefone.getText().toString();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        try {
            db.execSQL("INSERT INTO " + DatabaseHelper.TABLE_USER +
                    " (" + DatabaseHelper.COLUMN_USER_NAME + ", " +
                    DatabaseHelper.COLUMN_USER_EMAIL + ", " +
                    DatabaseHelper.COLUMN_USER_PASSWORD + ", " +
                    DatabaseHelper.COLUMN_USER_PHONE + ") VALUES (?, ?, ?, ?)", new Object[]{nome, email, senha, telefone});
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "Erro ao cadastrar usuário: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}

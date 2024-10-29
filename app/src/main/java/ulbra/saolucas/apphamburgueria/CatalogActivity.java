package ulbra.saolucas.apphamburgueria;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import ulbra.saolucas.apphamburgueria.DatabaseHelper;
import ulbra.saolucas.apphamburgueria.R;

public class CatalogActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalago);


        @SuppressLint("WrongViewCast") Button btnWhatsApp = findViewById(R.id.btnWhatsApp);
        dbHelper = new DatabaseHelper(this);

        loadProducts();

        btnWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactWhatsApp();
            }
        });
    }

    private void loadProducts() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_PRODUCT, null);
        ArrayList<String> products = new ArrayList<>();

        while (cursor.moveToNext()) {
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRODUCT_NAME));
            @SuppressLint("Range") double price = cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRODUCT_PRICE));
            products.add(name + " - R$ " + price);
        }

    }

    private void contactWhatsApp() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://wa.me/55XXXXXXXXXXX?text=Olá! Gostaria de fazer um pedido.")); // Coloque o número de telefone desejado
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "WhatsApp não está instalado.", Toast.LENGTH_SHORT).show();
        }
    }
}

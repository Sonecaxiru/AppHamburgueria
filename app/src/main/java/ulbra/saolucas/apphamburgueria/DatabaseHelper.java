package ulbra.saolucas.apphamburgueria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "hamburgueria.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USER = "User";
    public static final String COLUMN_USER_ID = "id_usuario";
    public static final String COLUMN_USER_NAME = "nome";
    public static final String COLUMN_USER_EMAIL = "email";
    public static final String COLUMN_USER_PASSWORD = "senha";
    public static final String COLUMN_USER_PHONE = "telefone";

    public static final String TABLE_PRODUCT = "Product";
    public static final String COLUMN_PRODUCT_ID = "id_produto";
    public static final String COLUMN_PRODUCT_NAME = "nome_produto";
    public static final String COLUMN_PRODUCT_DESCRIPTION = "descricao";
    public static final String COLUMN_PRODUCT_PRICE = "preco";
    public static final String COLUMN_PRODUCT_CATEGORY = "categoria";

    private static final String TABLE_USER_CREATE =
            "CREATE TABLE " + TABLE_USER + " (" +
                    COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USER_NAME + " TEXT, " +
                    COLUMN_USER_EMAIL + " TEXT UNIQUE, " +
                    COLUMN_USER_PASSWORD + " TEXT, " +
                    COLUMN_USER_PHONE + " TEXT);";

    private static final String TABLE_PRODUCT_CREATE =
            "CREATE TABLE " + TABLE_PRODUCT + " (" +
                    COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PRODUCT_NAME + " TEXT, " +
                    COLUMN_PRODUCT_DESCRIPTION + " TEXT, " +
                    COLUMN_PRODUCT_PRICE + " REAL, " +
                    COLUMN_PRODUCT_CATEGORY + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USER_CREATE);
        db.execSQL(TABLE_PRODUCT_CREATE);
        // Inserir produtos de exemplo
        db.execSQL("INSERT INTO " + TABLE_PRODUCT + " (" +
                COLUMN_PRODUCT_NAME + ", " +
                COLUMN_PRODUCT_DESCRIPTION + ", " +
                COLUMN_PRODUCT_PRICE + ", " +
                COLUMN_PRODUCT_CATEGORY + ") VALUES " +
                "('Hambúrguer Clássico', 'Hambúrguer com carne, queijo e alface', 19.90, 'Hambúrguer')," +
                "('Hambúrguer Bacon', 'Hambúrguer com bacon, queijo e cebola', 24.90, 'Hambúrguer')," +
                "('Refrigerante', 'Refrigerante de 350ml', 6.50, 'Bebida')," +
                "('Suco Natural', 'Suco de frutas', 7.00, 'Bebida');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        onCreate(db);
    }
}


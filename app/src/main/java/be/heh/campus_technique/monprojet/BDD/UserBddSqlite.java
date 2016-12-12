package be.heh.campus_technique.monprojet.BDD;

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Fabz on 9/11/2015.
 */

public class UserBddSqlite extends SQLiteOpenHelper {

    private static final String TABLE_USER = "table_user";
    private static final String COL_ID = "ID";
    private static final String COL_LOGIN = "LOGIN";
    private static final String COL_PASSWORD = "PASSWORD";
    private static final String COL_EMAIL = "EMAIL";
    private static final String CREATE_DB = "CREATE TABLE " +
            TABLE_USER + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_LOGIN + " TEXT NOT NULL, " + COL_PASSWORD + " TEXT NOT NULL, " +
            COL_EMAIL + " TEXT NOT NULL);";

    public UserBddSqlite(Context context, String name,
                         SQLiteDatabase.CursorFactory factory,
                         int version) {
        super (context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//Dans cette méthode, vous devez gérer les révisions de version de votre base de données
        db.execSQL("DROP TABLE " + TABLE_USER);
        onCreate(db);
    }
}
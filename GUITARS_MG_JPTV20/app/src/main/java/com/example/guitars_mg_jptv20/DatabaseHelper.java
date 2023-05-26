package com.example.guitars_mg_jptv20;

        import android.annotation.SuppressLint;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.database.sqlite.SQLiteDatabase;
        import android.content.Context;

        import java.util.ArrayList;
        import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "guitarStore.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "guitars"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_YEAR = "year";

    public static final String COLUMN_DESCRIPTION = "description";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }
    //------------------------------------------------------------------------------------
    /*
    Если база данных отсутствует или ее версия (которая задается в переменной SCHEMA) выше текущей,
     то срабатывает метод onCreate(). Метод onCreate() получает в качестве параметра базу данных
     приложения.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        Для выполнения запросов к SQLite используется метод execSQL().
        Он принимает sql-выражение CREATE TABLE, которое создает таблицу.
        Здесь также при необходимости мы можем выполнить и другие запросы, например,
        добавить какие-либо начальные данные. Так, в данном случае с помощью того же метода
        и выражения sql INSERT добавляется один объект в таблицу.
         */
        db.execSQL("CREATE TABLE guitars (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
                + " TEXT, " + COLUMN_YEAR + " INTEGER, " + COLUMN_DESCRIPTION + " TEXT);");
        // добавление начальных данных
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_YEAR  + ", " + COLUMN_DESCRIPTION + ") VALUES ('Acoustic guitar', 1981, 'The best guitar ever');");
    }
    //-----------------------------------------------------------------------------------
    /*
    В методе onUpgrade() происходит обновление схемы БД.
    если вам будет необходимо сохранить данные, этот метод может включать более сложную логику -
    добавления новых столбцов, удаление ненужных, добавление дополнительных данных и т.д.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }

}
package com.example.giuaki;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VanPhongPhamDatabase extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "GiuaKi";

    // Table name: Note.
    private static final String TABLE_NAME = "VANPHONGPHAM";

    public static final String COLUMN_ID ="ID";
    public static final String COLUMN_SOPHIEU ="MANV";
    public static final String COLUMN_NGAYCAP = "HOTEN";
    public static final String COLUMN_MAVPP = "NGAYSINH";
    public static final String COLUMN_MANV = "MAPB";
    public static final String COLUMN_SOLUONG = "SOLUONG";

    public VanPhongPhamDatabase(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Script to create table.
        String script = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + COLUMN_SOPHIEU + " TEXT NOT NULL UNIQUE,"
                + COLUMN_NGAYCAP + " TEXT NOT NULL,"
                + COLUMN_MAVPP + "TEXT NOT NULL,"
                + COLUMN_MANV + "TEXT NOT NULL,"
                + COLUMN_SOLUONG + "INTEGER NOT NULL)";
        // Execute script.
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Recreate
        onCreate(db);
    }
}

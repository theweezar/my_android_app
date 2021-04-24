package com.example.giuaki;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CapPhatDatabase extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "GiuaKi";

    // Table name: Note.
    private static final String TABLE_NAME = "CAPPHAT";

    public static final String COLUMN_ID ="ID";
    public static final String COLUMN_SOPHIEU ="MANV";
    public static final String COLUMN_NGAYCAP = "HOTEN";
    public static final String COLUMN_MAVPP = "NGAYSINH";
    public static final String COLUMN_MANV = "MAPB";
    public static final String COLUMN_SOLUONG = "SOLUONG";

    public CapPhatDatabase(Context context)  {
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

    public List<CapPhat> select(){
        SQLiteDatabase db = this.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                COLUMN_ID,
                COLUMN_SOPHIEU,
                COLUMN_NGAYCAP,
                COLUMN_MAVPP,
                COLUMN_MANV,
                COLUMN_SOLUONG
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = PhongBanDatabase.COLUMN_ID + " DESC";

        Cursor cursor = db.query(
                TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List<CapPhat> list_capphat = new ArrayList<>();

        while(cursor.moveToNext()){
            list_capphat.add(new CapPhat(
                    cursor.getLong(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getLong(5)
            ));
        }

        return list_capphat;
    }
}

package com.example.giuaki;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDatabase extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "GiuaKi";

    // Table name: Note.
    private static final String TABLE_NAME = "NHANVIEN";

    public static final String COLUMN_ID ="ID";
    public static final String COLUMN_MANV ="MANV";
    public static final String COLUMN_HOTEN = "HOTEN";
    public static final String COLUMN_NGAYSINH = "NGAYSINH";
    public static final String COLUMN_MAPB = "MAPB";

    public NhanVienDatabase(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Script to create table.
        String script = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + COLUMN_MANV + " TEXT NOT NULL UNIQUE,"
                + COLUMN_HOTEN + " TEXT NOT NULL,"
                + COLUMN_NGAYSINH + "TEXT NOT NULL,"
                + COLUMN_MAPB + "TEXT NOT NULL)";
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

    public void insert(NhanVien nhanvien){
        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(COLUMN_MANV, nhanvien.getMaNv());
        values.put(COLUMN_HOTEN, nhanvien.getHoTen());
        values.put(COLUMN_NGAYSINH, nhanvien.getNgaySinh());
        values.put(COLUMN_MAPB, nhanvien.getMaPb());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_NAME, null, values);
    }

    public List<NhanVien> select(){
        SQLiteDatabase db = this.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                COLUMN_ID,
                COLUMN_MANV,
                COLUMN_HOTEN,
                COLUMN_NGAYSINH,
                COLUMN_MAPB
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

        List<NhanVien> list_nhanvien = new ArrayList<>();

        while(cursor.moveToNext()){
            list_nhanvien.add(new NhanVien(
                    cursor.getLong(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            ));
        }

        return list_nhanvien;
    }
}

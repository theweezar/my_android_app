package com.example.giuaki;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class VanPhongPhamDatabase extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "GiuaKi";

    // Table name: Note.
    private static final String TABLE_NAME = "VANPHONGPHAM";

    public static final String COLUMN_ID ="ID";
    public static final String COLUMN_MAVPP ="MAVPP";
    public static final String COLUMN_TENVPP = "TENVPP";
    public static final String COLUMN_DVT = "DVT";
    public static final String COLUMN_GIANHAP = "GIANHAP";
    public static final String COLUMN_HINH = "HINH";

    public VanPhongPhamDatabase(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Script to create table.
        String script = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + COLUMN_MAVPP + " TEXT NOT NULL UNIQUE,"
                + COLUMN_TENVPP + " TEXT NOT NULL,"
                + COLUMN_DVT + "TEXT NOT NULL,"
                + COLUMN_GIANHAP + "TEXT NOT NULL,"
                + COLUMN_HINH + "BLOB)";
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

    public void insert(VanPhongPham vanPhongPham){
        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(COLUMN_MAVPP, vanPhongPham.getMaVpp());
        values.put(COLUMN_TENVPP, vanPhongPham.getTenVpp());
        values.put(COLUMN_DVT, vanPhongPham.getDvt());
        values.put(COLUMN_GIANHAP, vanPhongPham.getGiaNhap());
        values.put(COLUMN_HINH, vanPhongPham.getHinh());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_NAME, null, values);
    }

    public List<VanPhongPham> select(){
        SQLiteDatabase db = this.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                COLUMN_ID,
                COLUMN_MAVPP,
                COLUMN_TENVPP,
                COLUMN_DVT,
                COLUMN_GIANHAP,
                COLUMN_HINH
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

        List<VanPhongPham> list_vanphongpham = new ArrayList<>();

        while(cursor.moveToNext()){
            list_vanphongpham.add(new VanPhongPham(
                    cursor.getLong(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getBlob(5)
            ));
        }

        return list_vanphongpham;
    }
}

package com.example.giuaki;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QueryReport extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "GiuaKi.db";

    public QueryReport(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void cau1(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT NV.MANV, NV.HOTEN, PB.TENPB, VPP.TENVPP, SUM(CP.SOLUONG) AS TONGSL\n" +
                "FROM CAPPHAT CP, NHANVIEN NV, VANPHONGPHAM VPP, PHONGBAN PB\n" +
                "WHERE VPP.TENVPP = 'GIAY A4'\n" +
                "AND CP.IDNV = NV.ID\n" +
                "AND CP.IDVPP = VPP.ID\n" +
                "AND NV.IDPB = PB.ID\n" +
                "GROUP BY NV.MANV\n" +
                "ORDER BY TONGSL DESC\n" +
                "LIMIT 2";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.close();
    }
}

package com.activity.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class HoaDonDao {
    private SQLiteDatabase db;
    private HoaDon hoaDon;

    public HoaDonDao(Context context){
        SQLiteHelper dBmanager = new SQLiteHelper(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(HoaDon hoaDon){
        ContentValues values = new ContentValues();
        values.put("MAHOADON",hoaDon.getMaHoaDon());
        values.put("NGAYMUA",hoaDon.getNgay());
        return db.insert("HOADON",null,values);
    }
    public List<HoaDon> getAlldata(){
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * from HOADON";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            String mahd = cursor.getString(cursor.getColumnIndex("MAHOADON"));
            String ngaymua  = cursor.getString(cursor.getColumnIndex("NGAYMUA"));
            list.add(new HoaDon(mahd,ngaymua));
        }
        return list;
    }
}

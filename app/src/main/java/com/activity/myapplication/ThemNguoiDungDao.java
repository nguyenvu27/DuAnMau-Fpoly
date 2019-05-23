package com.activity.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ThemNguoiDungDao {
    private SQLiteDatabase db;
    private ThemNguoiDung nguoiDung ;

    public ThemNguoiDungDao(Context context){
        SQLiteHelper dBmanager = new SQLiteHelper(context);
        db = dBmanager.getWritableDatabase();
    }

    public long insert(ThemNguoiDung themNguoiDung){
        ContentValues values = new ContentValues();
        values.put("TENDANGNHAP",themNguoiDung.getTenDangNhap());
        values.put("MATKHAU",themNguoiDung.getMatKhau());
        values.put("NHAPLAIMATKHAU",themNguoiDung.getNhapLaiMatKhau());
        values.put("PHONE",themNguoiDung.getPhone());
        values.put("HOTEN",themNguoiDung.getHoTen());
        return db.insert("THEMNGUOIDUNG",null,values);
    }
    public List<ThemNguoiDung> getAlldata(){
        List<ThemNguoiDung> list = new ArrayList<>();
        String sql = "select * from THEMNGUOIDUNG";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            String TenDangNhap = cursor.getString(cursor.getColumnIndex("TENDANGNHAP"));
            String MatKhau = cursor.getString(cursor.getColumnIndex("MATKHAU"));
            String NhapLaiMatKhau = cursor.getString(cursor.getColumnIndex("NHAPLAIMATKHAU"));
            String Phone = cursor.getString(cursor.getColumnIndex("PHONE"));
            String HoTen = cursor.getString(cursor.getColumnIndex("HOTEN"));

            list.add(new ThemNguoiDung(TenDangNhap, MatKhau, NhapLaiMatKhau, Phone, HoTen));
        }
        return list;
    }
}

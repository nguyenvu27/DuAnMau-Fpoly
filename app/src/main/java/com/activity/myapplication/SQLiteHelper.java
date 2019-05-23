package com.activity.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {

private static final String DATABASE_NAME = "QUAN_LY_SACH" ;
private static final String TABLE_HOADON = "HOADON";
    private static final String TABLE_THEM_NGUOI_DUNG = "THEMNGUOIDUNG";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase() ;
        database.execSQL(sql);
    }

    public void insertData(String stt, String masach, String tensach, String sotien, byte[] image){
        SQLiteDatabase database = getWritableDatabase() ;
        String sql = "INSERT INTO RECORD VALUES(NULL, ?, ?, ?, ?, ?)" ;
        SQLiteStatement statement = database.compileStatement(sql) ;
        statement.clearBindings();

        statement.bindString(1, stt);
        statement.bindString(2, masach);
        statement.bindString(3, tensach);
        statement.bindString(4, sotien);
        statement.bindBlob(5, image);

        statement.executeInsert() ;
    }

    public void updateDate(String stt, String masach, String tensach, String sotien, byte[] image, int id){
        SQLiteDatabase database = getWritableDatabase() ;
        String sql = "UPDATE RECORD SET stt=?, masach=?, tensach=?, sotien=?, image=? WHERE id=?" ;
        SQLiteStatement statement = database.compileStatement(sql) ;

        statement.bindString(1, stt);
        statement.bindString(2, masach);
        statement.bindString(3, tensach);
        statement.bindString(4, sotien);
        statement.bindBlob(5, image);
        statement.bindDouble(6, id);

        statement.execute();
        database.close();
    }

    public void deleteData(int id){
        SQLiteDatabase database = getWritableDatabase() ;
        String sql ="DELETE FROM RECORD WHERE id=?" ;
        SQLiteStatement statement = database.compileStatement(sql) ;
        statement.clearBindings();
        statement.bindDouble(1, (double) id);

        statement.execute();
        database.close();

    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase() ;
        return database.rawQuery(sql, null) ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String hoadon = "create table HOADON (" +
                "MAHOADON TEXT PRIMARY KEY," +
                "NGAYMUA DATE)";
        db.execSQL(hoadon);
        String themnguoidung = "create table THEMNGUOIDUNG("
                +"TENDANGNHAP TEXT PRIMARY KEY,"
                +"MATKHAU TEXT,"+
                "NHAPLAIMATKHAU TEXT,"
                +"PHONE NUMBER," +"HOTEN TEXT)" ;
        db.execSQL(themnguoidung);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_HOADON);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_THEM_NGUOI_DUNG);
        onCreate(db);
    }
}

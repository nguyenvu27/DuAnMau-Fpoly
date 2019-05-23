package com.activity.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class DS_themnguoidungActivity extends AppCompatActivity {

    ListView lv_danhsach;
    Adapter_themnhanvien adapter_themnhanvien ;
    ThemNguoiDungDao themNguoiDungDao ;

    ThemNguoiDung themNguoiDung ;

    List<ThemNguoiDung> themNguoiDungs ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_themnguoidung);

        lv_danhsach = findViewById(R.id.lv3);
        themNguoiDungDao = new ThemNguoiDungDao(this);
        themNguoiDungs = themNguoiDungDao.getAlldata();
        adapter_themnhanvien = new Adapter_themnhanvien(this,R.layout.item_themnguoidung,themNguoiDungs);
        lv_danhsach.setAdapter(adapter_themnhanvien);
    }
}

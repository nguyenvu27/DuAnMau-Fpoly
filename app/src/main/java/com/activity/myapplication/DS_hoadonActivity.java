package com.activity.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class DS_hoadonActivity extends AppCompatActivity {
    ListView lv_danhsach;
    Adapter_hoadon adapter_hoadon;
    HoaDonDao hoaDonDAO;
    HoaDon hoaDon;
    List<HoaDon> hoaDons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_hoadon);

        lv_danhsach = findViewById(R.id.lv);
        hoaDonDAO = new HoaDonDao(this);
        hoaDons = hoaDonDAO.getAlldata();
        adapter_hoadon = new Adapter_hoadon(this,R.layout.item_hoadon,hoaDons);
        lv_danhsach.setAdapter(adapter_hoadon);
    }
}

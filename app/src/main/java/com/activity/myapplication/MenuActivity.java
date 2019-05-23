package com.activity.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    ImageView image_admin, image_theloai, image_hoadon, image_sachcondu, image_sachbanchhay, image_thongke ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        image_admin = findViewById(R.id.imageView) ;
        image_theloai = findViewById(R.id.image_theLoai) ;
        image_hoadon = findViewById(R.id.image_hoaDon) ;
        image_sachcondu = findViewById(R.id.image_sach) ;
        image_sachbanchhay = findViewById(R.id.image_sachBanChay) ;
        image_thongke = findViewById(R.id.image_thongKe) ;

        image_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AdminActivity.class) ;
                startActivity(intent);
            }
        });

        image_theloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, TheloaiActivity.class) ;
                startActivity(intent);
            }
        });

        image_hoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, HoaDonActivity.class) ;
                startActivity(intent);
            }
        });

        image_sachcondu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, SachConDuActivity.class) ;
                startActivity(intent);
            }
        });

        image_sachbanchhay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, SachBanChayActivity.class) ;
                startActivity(intent);
            }
        });

        image_thongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ThongKeActivity.class) ;
                startActivity(intent);
            }
        });

    }
}

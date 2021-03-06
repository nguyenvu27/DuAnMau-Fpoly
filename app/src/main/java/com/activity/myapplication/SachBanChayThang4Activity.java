package com.activity.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SachBanChayThang4Activity extends AppCompatActivity {

    ListView listView ;
    String[] name = {"NẾU KHÔNG LÀ TÌNH YÊU", "MANDARIN CỦA TÔI",
            "NHƯ HOA NHƯ SƯƠNG LẠI NHƯ GIÓ ", "Lập trình android cơ bản",
            "Lập trình Java", "Lập trình web", "Lập trình PHP",
            "Cơ sở dữ liệu", "Tiếng Anh", "HTML5 & CSS3", "Marketing", "Javascript"};

    String[] gia = {"75.000đ", "100.000đ",
            "75.000đ", "255.000đ",
            "150.000đ", "60.000đ", "70.000đ",
            "120.000đ", "125.000đ", "300.000đ", "225.000đ", "300.000đ"};

    Integer[] img = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach_ban_chay_thang4);

        listView = findViewById(R.id.lvSachBanChayThang4) ;
        CustomListViewSachBanChayThang4 customListViewSachBanChayThang4= new CustomListViewSachBanChayThang4(this, name, gia, img) ;
        listView.setAdapter(customListViewSachBanChayThang4);
    }
}

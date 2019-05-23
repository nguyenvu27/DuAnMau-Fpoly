package com.activity.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Thang3Activity extends AppCompatActivity {

    ListView listView ;
    String[] name = {"Rừng Xà Nu", "Vợ chồng A phủ",
            "Tào Tháo", "Lập trình android cơ bản",
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
        setContentView(R.layout.activity_thang3);

        listView = findViewById(R.id.lvThang3) ;
        CustomListViewThang3 customListViewThang3 = new CustomListViewThang3(this, name, gia, img) ;
        listView.setAdapter(customListViewThang3);
    }
}

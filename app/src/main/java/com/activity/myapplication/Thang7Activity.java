package com.activity.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Thang7Activity extends AppCompatActivity {

    ListView listView ;
    String[] name = {"Javascript", "Lập trình web",
            "Tào Tháo", "Lập trình android cơ bản",
            "Lập trình Java", "Vợ chồng A phủ", "Lập trình PHP",
            "Cơ sở dữ liệu", "Tiếng Anh", "HTML5 & CSS3", "Marketing", "Rừng Xà Nu"};

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
        setContentView(R.layout.activity_thang7);
        listView = findViewById(R.id.lvThang7) ;
        CustomListViewThang7 customListViewThang7 = new CustomListViewThang7(this, name, gia, img) ;
        listView.setAdapter(customListViewThang7);
    }
}

package com.activity.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SachBanChayThang1Activity extends AppCompatActivity {

    ListView listView ;
    String[] name = {"Khéo ăn khéo nói sẽ được lòng thiên hạ", "Gia Cát Lượng",
            "Tào Tháo", "Nếu ngày mai không bao giờ đến",
            "Hôm nay tôi thất tình", "Lập trình web", "Lập trình PHP",
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
        setContentView(R.layout.activity_sach_ban_chay_thang1);

        listView = findViewById(R.id.lvSachBanChayThang1) ;
        CustomListViewSachBanChayThang1 customListViewSachBanChayThang1 = new CustomListViewSachBanChayThang1(this, name, gia, img) ;
        listView.setAdapter(customListViewSachBanChayThang1);
    }
}

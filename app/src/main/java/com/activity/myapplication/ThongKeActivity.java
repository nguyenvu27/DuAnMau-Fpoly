package com.activity.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ThongKeActivity extends AppCompatActivity {
    private TabLayout tabLayout ;
    private ViewPager viewPager ;
    private ViewPaqerAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        tabLayout = findViewById(R.id.tablayout_id) ;
        viewPager = findViewById(R.id.viewpager_id) ;
        adapter = new ViewPaqerAdapter(getSupportFragmentManager()) ;

        adapter.AddFragment(new fragment111(), "Ngày");
        adapter.AddFragment(new fragment222(), "Tuần");
        adapter.AddFragment(new fragment333(), "Tháng");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

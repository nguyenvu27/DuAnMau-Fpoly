package com.activity.myapplication;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SachConDuActivity extends AppCompatActivity {

    SearchView searchView ;
    ListView listView ;
    String[] name={"Khoa học", "Thiếu nhi", "Truyện ngắn", "Truyện tranh", "Văn học", "Sách tham khảo",
            "Sách thiếu nhi", "Sách lập trình", "Sách tiếng Anh", "Tiểu thuyết", "Thơ", "Lịch sử"} ;
    ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach_con_du);

        listView = findViewById(R.id.lv2) ;
        searchView = (SearchView)findViewById(R.id.searchView2) ;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name) ;
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){
                    Intent intent = new Intent(SachConDuActivity.this, Thang1Activity.class) ;
                    intent.putExtra("Khoa học", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==1){
                    Intent intent = new Intent(SachConDuActivity.this, Thang2Activity.class) ;
                    intent.putExtra("Thiếu nhi", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==2){
                    Intent intent = new Intent(SachConDuActivity.this, Thang3Activity.class) ;
                    intent.putExtra("Truyện ngắn", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==3){
                    Intent intent = new Intent(SachConDuActivity.this, Thang4Activity.class) ;
                    intent.putExtra("Truyện tranh", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==4){
                    Intent intent = new Intent(SachConDuActivity.this, Thang5Activity.class) ;
                    intent.putExtra("Văn học", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==5){
                    Intent intent = new Intent(SachConDuActivity.this, Thang6Activity.class) ;
                    intent.putExtra("Sách tham khảo", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==6){
                    Intent intent = new Intent(SachConDuActivity.this, Thang7Activity.class) ;
                    intent.putExtra("Sách thiếu nhi", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==7){
                    Intent intent = new Intent(SachConDuActivity.this, Thang8Activity.class) ;
                    intent.putExtra("Sách lập trình", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==8){
                    Intent intent = new Intent(SachConDuActivity.this, Thang9Activity.class) ;
                    intent.putExtra("Sách tiếng Anh", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==9){
                    Intent intent = new Intent(SachConDuActivity.this, Thang10Activity.class) ;
                    intent.putExtra("Tiểu thuyết", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==10){
                    Intent intent = new Intent(SachConDuActivity.this, Thang11Activity.class) ;
                    intent.putExtra("Thơ", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==11){
                    Intent intent = new Intent(SachConDuActivity.this, Thang12Activity.class) ;
                    intent.putExtra("Lịch sử", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }



            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }
}

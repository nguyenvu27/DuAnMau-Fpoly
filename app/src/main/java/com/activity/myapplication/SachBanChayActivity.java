package com.activity.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class SachBanChayActivity extends AppCompatActivity {

SearchView searchView ;
ListView listView ;
String[] name={"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"} ;
ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach_ban_chay);

        listView = findViewById(R.id.lv) ;
        searchView = (SearchView)findViewById(R.id.searchView) ;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name) ;
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(SachBanChayActivity.this, SachBanChayThang1Activity.class);
                    intent.putExtra("Tháng 1", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(SachBanChayActivity.this, SachBanChayThang2Activity.class);
                    intent.putExtra("Tháng 2", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(SachBanChayActivity.this, SachBanChayThang3Activity.class);
                    intent.putExtra("Tháng 3", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(SachBanChayActivity.this, SachBanChayThang4Activity.class);
                    intent.putExtra("Tháng 4", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(SachBanChayActivity.this, SachBanChayThang5Activity.class);
                    intent.putExtra("Tháng 5", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(SachBanChayActivity.this, SachBanChayThang6Activity.class);
                    intent.putExtra("Tháng 6", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(SachBanChayActivity.this, SachBanChayThang7Activity.class);
                    intent.putExtra("Tháng 7", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(SachBanChayActivity.this, SachBanChayThang8Activity.class);
                    intent.putExtra("Tháng 8", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                } else if (position == 8) {
                    Intent intent = new Intent(SachBanChayActivity.this, SachBanChayThang9Activity.class);
                    intent.putExtra("Tháng 9", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                } else if (position == 9) {
                    Intent intent = new Intent(SachBanChayActivity.this, SachBanChayThang10Activity.class);
                    intent.putExtra("Tháng 10", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                } else if (position == 10) {
                    Intent intent = new Intent(SachBanChayActivity.this, SachBanChayThang11Activity.class);
                    intent.putExtra("Tháng 11", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                } else if (position == 11) {
                    Intent intent = new Intent(SachBanChayActivity.this, SachBanChayThang12Activity.class);
                    intent.putExtra("Tháng 12", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                }      }
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


            }}

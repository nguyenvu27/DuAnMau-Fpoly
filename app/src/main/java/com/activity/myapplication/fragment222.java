package com.activity.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class fragment222 extends Fragment {

    View v ;
    public fragment222() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment222, container, false) ;

        String[] menuItem =  {"Tuần 1", "Tuần 2", "Tuần 3", "Tuần 4"} ;
        ListView listView = v.findViewById(R.id.lv_thongKe2) ;

        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, menuItem);

        listView.setAdapter(listviewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getActivity(), ThongKeTuanActivity.class);

                    startActivity(intent);
            }else if (position == 1){
                    Intent intent = new Intent(getActivity(), ThongKeTuanActivity.class);

                    startActivity(intent);
                }else if (position == 2){
                    Intent intent = new Intent(getActivity(), ThongKeTuanActivity.class);

                    startActivity(intent);
                }
                else if (position == 3){
                    Intent intent = new Intent(getActivity(), ThongKeTuanActivity.class);

                    startActivity(intent);
                }

            }
        });

        return v ;
    }
}

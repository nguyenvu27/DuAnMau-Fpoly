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

public class fragment333 extends Fragment {
    View v ;
    public fragment333() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment333, container, false) ;
        String[] menuItem =  {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"} ;
        ListView listView = v.findViewById(R.id.lv_thongKe3) ;

        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, menuItem);

        listView.setAdapter(listviewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getActivity(), ThongKeThangActivity.class);

                    startActivity(intent);
                }else if (position == 1){
                    Intent intent = new Intent(getActivity(), ThongKeThangActivity.class);

                    startActivity(intent);
                }else if (position == 2){
                    Intent intent = new Intent(getActivity(), ThongKeThangActivity.class);

                    startActivity(intent);
                }
                else if (position == 3){
                    Intent intent = new Intent(getActivity(), ThongKeThangActivity.class);

                    startActivity(intent);
                }
                else if (position == 4){
                    Intent intent = new Intent(getActivity(), ThongKeThangActivity.class);

                    startActivity(intent);
                }
                else if (position == 5){
                    Intent intent = new Intent(getActivity(), ThongKeThangActivity.class);

                    startActivity(intent);
                }
                else if (position == 6){
                    Intent intent = new Intent(getActivity(), ThongKeThangActivity.class);

                    startActivity(intent);
                }
                else if (position == 7){
                    Intent intent = new Intent(getActivity(), ThongKeThangActivity.class);

                    startActivity(intent);
                }
                else if (position == 8){
                    Intent intent = new Intent(getActivity(), ThongKeThangActivity.class);

                    startActivity(intent);
                }
                else if (position == 9){
                    Intent intent = new Intent(getActivity(), ThongKeThangActivity.class);

                    startActivity(intent);
                }
                else if (position == 10){
                    Intent intent = new Intent(getActivity(), ThongKeThangActivity.class);

                    startActivity(intent);
                }
                else if (position == 11){
                    Intent intent = new Intent(getActivity(), ThongKeThangActivity.class);

                    startActivity(intent);
                }



            }
        });
        return v ;
    }
}

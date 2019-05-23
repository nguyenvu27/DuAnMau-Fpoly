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

public class fragment111 extends Fragment {
    View v;

    public fragment111() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment111, container, false);

        String[] menuItem = {"Ngày 1", "Ngày 2", "Ngày 3", "Ngày 4", "Ngày 5", "Ngày 6", "Ngày 7", "Ngày 8", "Ngày 9", "Ngày 10", "Ngày 11", "Ngày 12",
                "Ngày 13", "Ngày 14", "Ngày 15", "Ngày 16", "Ngày 17", "Ngày 18", "Ngày 19", "Ngày 20", "Ngày 21", "Ngày 22", "Ngày 23"
                , "Ngày 24", "Ngày 25", "Ngày 26", "Ngày 27", "Ngày 28", "Ngày 29", "Ngày 30", "Ngày 31"};
        ListView listView = v.findViewById(R.id.lv_thongKe);

        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, menuItem);

        listView.setAdapter(listviewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }else if (position == 1){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }else if (position == 2){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 3){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 4){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 5){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 6){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 7){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 8){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 9){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 10){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 11){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 12){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 13){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 14){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 15){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 16){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 17){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 18){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 19){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 20){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 21){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 22){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 23){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 24){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 25){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 26){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 27){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 27){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 29){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }
                else if (position == 30){
                    Intent intent = new Intent(getActivity(), ThongKeNgayActivity.class);

                    startActivity(intent);
                }

            }
        });

        return v;
    }
    }

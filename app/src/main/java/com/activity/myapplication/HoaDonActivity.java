package com.activity.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class HoaDonActivity extends AppCompatActivity {

    EditText MaHoaDon ;
    TextView dateTime ;
    Button chon1, chon2 ;

    Adapter_hoadon adapter_hoadon;
    List<HoaDon> hoaDons;
    HoaDon hoaDon;
    HoaDonDao hoaDonDAO;

    private int mYear, mMonth, mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);

        MaHoaDon = findViewById(R.id.edMaHoaDon) ;
        dateTime = findViewById(R.id.DateTime) ;
        hoaDonDAO = new HoaDonDao(HoaDonActivity.this) ;
        hoaDons = hoaDonDAO.getAlldata() ;
        chon1 = findViewById(R.id.btnChon1) ;
        chon2 = findViewById(R.id.btnChon2) ;

        chon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == chon1) {

                    // Get Current Date
                    final Calendar c = Calendar.getInstance();
                    mYear = c.get(Calendar.YEAR);
                    mMonth = c.get(Calendar.MONTH);
                    mDay = c.get(Calendar.DAY_OF_MONTH);


                    DatePickerDialog datePickerDialog = new DatePickerDialog(HoaDonActivity.this,
                            new DatePickerDialog.OnDateSetListener() {

                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {

                                   dateTime.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                }
                            }, mYear, mMonth, mDay);
                    datePickerDialog.show();

                }
            }
        });

        chon2 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mahoadon = MaHoaDon.getText().toString();
                String ngaymua = dateTime.getText().toString();
                hoaDon = new HoaDon(mahoadon,ngaymua);
                hoaDonDAO.insert(hoaDon);
                Toast.makeText(HoaDonActivity.this, "them thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void xemHoaDon(View view) {
        Intent intent = new Intent(HoaDonActivity.this, DS_hoadonActivity.class) ;
        startActivity(intent);
    }
}

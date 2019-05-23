package com.activity.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class ThemNhanVienActivity extends AppCompatActivity {

    EditText TenDangNhap, MatKhau, NhapLaiMatKhau, Phone, HoTen ;
    Button Luu ;
    Adapter_themnhanvien adapter_themnhanvien ;
    List<ThemNguoiDung> themNguoiDungs ;
    ThemNguoiDung themNguoiDung ;
    ThemNguoiDungDao themNguoiDungDao ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhan_vien);

        TenDangNhap = findViewById(R.id.edtTenDangNhap) ;
        MatKhau = findViewById(R.id.edtMatKhau) ;
        NhapLaiMatKhau = findViewById(R.id.edtNhapLaiPass) ;
        Phone = findViewById(R.id.edtPhone)  ;
        HoTen = findViewById(R.id.edtHoVaTen) ;

        Luu = findViewById(R.id.btnAdd) ;


        themNguoiDungDao = new ThemNguoiDungDao(ThemNhanVienActivity.this) ;
        themNguoiDungs = themNguoiDungDao.getAlldata() ;

        Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String tendangnhap = TenDangNhap.getText().toString();
                String matkhau = MatKhau.getText().toString();
                String nhaplaimatkhau = NhapLaiMatKhau.getText().toString();
                String phone = Phone.getText().toString();
                String hoten = HoTen.getText().toString();

                if (tendangnhap.isEmpty() && matkhau.isEmpty() && nhaplaimatkhau.isEmpty() && phone.isEmpty() && hoten.isEmpty()){
                    Toast.makeText(ThemNhanVienActivity.this, "Bạn cần điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    themNguoiDung = new ThemNguoiDung(tendangnhap, matkhau, nhaplaimatkhau, phone,hoten) ;
                    themNguoiDungDao.insert(themNguoiDung);
                    Toast.makeText(ThemNhanVienActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    public void xemThemNguoiDung(View view) {
        Intent intent2 = new Intent(ThemNhanVienActivity.this, DS_themnguoidungActivity.class) ;
        startActivity(intent2);
    }
}

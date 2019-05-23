package com.activity.myapplication;

public class ThemNguoiDung {
    String TenDangNhap, MatKhau, NhapLaiMatKhau, Phone, HoTen;

    public ThemNguoiDung(String tenDangNhap, String matKhau, String nhapLaiMatKhau, String phone, String hoTen) {
        TenDangNhap = tenDangNhap;
        MatKhau = matKhau;
        NhapLaiMatKhau = nhapLaiMatKhau;
        Phone = phone;
        HoTen = hoTen;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        TenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getNhapLaiMatKhau() {
        return NhapLaiMatKhau;
    }

    public void setNhapLaiMatKhau(String nhapLaiMatKhau) {
        NhapLaiMatKhau = nhapLaiMatKhau;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }
}

package com.activity.myapplication;

public class HoaDon  {

   private String MaHoaDon, Ngay ;

    public HoaDon(String maHoaDon, String ngay) {
        MaHoaDon = maHoaDon;
        Ngay = ngay;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        MaHoaDon = maHoaDon;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }
}

package com.activity.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter_themnhanvien extends ArrayAdapter<ThemNguoiDung> {
    private List<ThemNguoiDung> themNguoiDungs;
    private LayoutInflater inflater;


    public Adapter_themnhanvien(@NonNull Context context, int resource, @NonNull List<ThemNguoiDung> objects) {
        super(context, resource, objects);
        this.themNguoiDungs = objects;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Adapter_themnhanvien.ViewHodel hodel;
        if (convertView == null){
            hodel = new ViewHodel();
            convertView = inflater.inflate(R.layout.item_themnguoidung,parent,false);
            hodel.tv_tendangnhap = convertView.findViewById(R.id.tv_tendangnhap);
            hodel.tv_matkhau = convertView.findViewById(R.id.tv_matkhau);
            hodel.tv_nhaplaimatkhau = convertView.findViewById(R.id.tv_nhaplaimatkhau);
            hodel.tv_phone = convertView.findViewById(R.id.tv_phone);
            hodel.tv_hoten = convertView.findViewById(R.id.tv_hoten);
            convertView.setTag(hodel);
        }else {
            hodel = (ViewHodel) convertView.getTag();
        }


        ThemNguoiDung themNguoiDung =  themNguoiDungs.get(position);

        hodel.tv_tendangnhap.setText(themNguoiDung.getTenDangNhap());
        hodel.tv_matkhau.setText(themNguoiDung.getMatKhau());
        hodel.tv_nhaplaimatkhau.setText(themNguoiDung.getNhapLaiMatKhau());
        hodel.tv_phone.setText(themNguoiDung.getPhone());
        hodel.tv_hoten.setText(themNguoiDung.getHoTen());

        return convertView;
    }

    public class ViewHodel{
        TextView tv_tendangnhap,tv_matkhau, tv_nhaplaimatkhau, tv_phone, tv_hoten;
    }
}

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

public class Adapter_hoadon extends ArrayAdapter<HoaDon> {

    private List<HoaDon> hoaDons;
    private LayoutInflater inflater;

    public Adapter_hoadon(@NonNull Context context, int resource, @NonNull List<HoaDon> objects) {
        super(context, resource, objects);
        this.hoaDons = objects;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHodel hodel;
        if (convertView == null){
            hodel = new ViewHodel();
            convertView = inflater.inflate(R.layout.item_hoadon,parent,false);
            hodel.tv_mahoadon = convertView.findViewById(R.id.tv_mahoadon);
            hodel.tv_ngaymua = convertView.findViewById(R.id.tv_ngaymua);
            convertView.setTag(hodel);
        }else {
            hodel = (ViewHodel) convertView.getTag();
        }

        HoaDon hoaDon = hoaDons.get(position);
        hodel.tv_ngaymua.setText(hoaDon.getNgay());
        hodel.tv_mahoadon.setText(hoaDon.getMaHoaDon());
        return convertView;
    }

    public class ViewHodel{
        TextView tv_mahoadon,tv_ngaymua;
    }
}

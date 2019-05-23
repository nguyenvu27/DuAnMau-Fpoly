package com.activity.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListViewSachBanChayThang11 extends ArrayAdapter<String> {

    private String[] name ;
    private String[] gia ;
    private  Integer[] img ;
    private Activity context ;

    public CustomListViewSachBanChayThang11(Activity context, String[] name , String[] gia, Integer[] img  ) {
        super(context, R.layout.item_sach_ban_chay_thang11, name);

        this.context = context ;
        this.name = name ;
        this.gia = gia ;
        this.img = img ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView ;
        ViewHolder viewHolder = null ;
        if (r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater() ;
            r=layoutInflater.inflate(R.layout.item_sach_ban_chay_thang11, null, true) ;
            viewHolder = new ViewHolder(r) ;
            r.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) r.getTag() ;
        }
        viewHolder.imageView.setImageResource(img[position]);
        viewHolder.textView1.setText(name[position]);
        viewHolder.textView2.setText(gia[position]);
        return r;
    }
    class ViewHolder{
        TextView textView1, textView2 ;
        ImageView imageView ;

        ViewHolder(View v){
            textView1 = (TextView)v.findViewById(R.id.tv_tensach) ;
            textView2 = (TextView)v.findViewById(R.id.tv_gia) ;
            imageView = (ImageView)v.findViewById(R.id.imgSachBanChayThang11) ;
        }
    }
}

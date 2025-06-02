package com.example.tourism;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class adapterForPlaces extends BaseAdapter {
    Bitmap images[];
    Context con;
    adapterForPlaces(Context c,Bitmap[]imgs){
        con=c;
        images=imgs;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(con).inflate(R.layout.placescard,parent,false);
        }
        ImageView img=convertView.findViewById(R.id.placeImg);
        img.setImageBitmap(images[position]);
        return convertView;
    }
}

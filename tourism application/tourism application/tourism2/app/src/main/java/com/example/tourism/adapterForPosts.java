package com.example.tourism;

import android.app.Activity;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_MULTI_PROCESS;
import static android.content.Context.MODE_PRIVATE;

public class adapterForPosts extends BaseAdapter {
    Context con;
    public String aboutPost[];
    public Bitmap images[];
    public String Text;
    public int pos;
    public TextView about;
    public View view;
    adapterForPosts(Context c, String []text, Bitmap []im){
        con=c;
        aboutPost=text;
        images=im;
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
            convertView= LayoutInflater.from(con).inflate(R.layout.postcard,parent,false);
        }
        position=getCount()-position-1;
        about= convertView.findViewById(R.id.aboutPost);
        about.setText(aboutPost[position]);
        ImageView imageView=convertView.findViewById(R.id.postimg);
        imageView.setImageBitmap(images[position]);
        int finalPosition = position;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Text =aboutPost[finalPosition];
                pos=finalPosition;
                //Toast.makeText(con,Text,Toast.LENGTH_SHORT).show();

            }
        });


        view=convertView;
        return convertView;
    }
    public int getPosition(){
        return pos;
    }
    public String getItemSelectedText() {
        return aboutPost[pos];
    }
    public View getCurrentView(){
        return view;
    }

   /* public void showImg(String imgname,View convertView){

        StorageReference imageRef=storage.getReference()
                .child("images")
                .child(imgname);

        imageRef.getBytes(4096*4096)
                .addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        Bitmap image= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                        ImageView imageView=convertView.findViewById(R.id.postimg);
                        imageView.setImageBitmap(image);
                    }
                });

    }*/
}

package com.example.tourism;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class The_Shortest extends AppCompatActivity {
    public String country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the__shortest);


        country=getIntent().getExtras().getString("country");

        ImageView q1=findViewById(R.id.imageView30);
        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","الكرنك");
                startActivity(s1);
            }
        });
        ImageView q2=findViewById(R.id.imageView31);


        q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","معبد الاقصر");
                startActivity(s1);
            }
        });
        ImageView q3=findViewById(R.id.imageView32);


        q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","وادي الملوك");
                startActivity(s1);
            }
        });
        ImageView q4=findViewById(R.id.imageView33);


        q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","تمثالي ممنون");
                startActivity(s1);
            }
        });
        ImageView q5=findViewById(R.id.imageView34);


        q5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","متحف الاقصر");
                startActivity(s1);
            }
        });
        ImageView q6=findViewById(R.id.imageView35);


        q6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","متحف التحنيط");
                startActivity(s1);
            }
        });
        ImageView q7=findViewById(R.id.imageView36);


        q7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","متحف النيل للبرديات");
                startActivity(s1);
            }
        });
        ImageView q8=findViewById(R.id.imageView38);


        q8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","ملاهي وحديقة حيوان الندي لاند");
                startActivity(s1);
            }
        });

    }
}
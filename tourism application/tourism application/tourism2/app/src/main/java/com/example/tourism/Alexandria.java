package com.example.tourism;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Alexandria extends AppCompatActivity {
    public String country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alexandria);
        ImageView z1=findViewById(R.id.imageView2);

        country=getIntent().getExtras().getString("country");

        z1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","قلعة قايتباي");
                startActivity(s1);
            }
        });
        ImageView z2=findViewById(R.id.imageView18);


        z2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","مكتبة الإسكندرية الجديدة");
                startActivity(s1);
            }
        });
        ImageView z3=findViewById(R.id.imageView19);



        z3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","قصر المنتزة");
                startActivity(s1);
            }
        });
        ImageView z4=findViewById(R.id.imageView);



        z4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","كورنيش الاسكندرية");
                startActivity(s1);
            }
        });
        ImageView z5=findViewById(R.id.imageView20);



        z5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","متحف الأحياء المائية");
                startActivity(s1);
            }
        });
        ImageView z6=findViewById(R.id.imageView21);



        z6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","متحف المجوهرات الملكية");
                startActivity(s1);
            }
        });
        ImageView z7=findViewById(R.id.imageView22);



        z7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","متحف الأسكندرية القومي");
                startActivity(s1);
            }
        });
        ImageView z8=findViewById(R.id.imageView23);



        z8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","مسجد ابى العباس المرسى");
                startActivity(s1);
            }
        });
        ImageView z9=findViewById(R.id.imageView24);



        z9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","مسجد القائد ابراهيم");
                startActivity(s1);
            }
        });
        ImageView z10=findViewById(R.id.imageView25);



        z10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","كنيسة المرقسية");
                startActivity(s1);
            }
        });
        ImageView z11=findViewById(R.id.imageView26);



        z11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","كنيسة الشهيد مارمينا");
                startActivity(s1);
            }
        });
        ImageView z12=findViewById(R.id.imageView27);



        z12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","حدائق المنتزه");
                startActivity(s1);
            }
        });
        ImageView z13=findViewById(R.id.imageView28);


        z13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","حدائق الشلالات");
                startActivity(s1);
            }
        });
        ImageView z14=findViewById(R.id.imageView29);



        z14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","حدائق أنطونيادس");
                startActivity(s1);
            }
        });
    }
}
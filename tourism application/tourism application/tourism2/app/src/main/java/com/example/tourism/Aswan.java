package com.example.tourism;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Aswan extends AppCompatActivity {
    public String country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aswan);
        ImageView x1=findViewById(R.id.imageView39);

        country=getIntent().getExtras().getString("country");

        x1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","السد العالى");
                startActivity(s1);
            }
        });
        ImageView x2=findViewById(R.id.imageView40);

        x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","معبد فيلة");
                startActivity(s1);
            }
        });
        ImageView x3=findViewById(R.id.imageView41);

        x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","معبد ابو سمبل");
                startActivity(s1);
            }
        });
        ImageView x4=findViewById(R.id.imageView42);

        x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","جزيرة الفنتين");
                startActivity(s1);
            }
        });
        ImageView x5=findViewById(R.id.imageView44);

        x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","متحف أسوان");
                startActivity(s1);
            }
        });
        ImageView x6=findViewById(R.id.imageView45);

        x6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","متحف النوبة");
                startActivity(s1);
            }
        });
        ImageView x7=findViewById(R.id.imageView48);

        x7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","متحف النيل");
                startActivity(s1);
            }
        });
        ImageView x8=findViewById(R.id.imageView49);

        x8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","جزيرة النباتات");
                startActivity(s1);
            }
        });
        ImageView x9=findViewById(R.id.imageView50);
        x9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","كورنيش اسوان");
                startActivity(s1);
            }
        });

        ImageView x10=findViewById(R.id.imageView51);
        x10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","شارع السوق");
                startActivity(s1);
            }
        });

    }
}
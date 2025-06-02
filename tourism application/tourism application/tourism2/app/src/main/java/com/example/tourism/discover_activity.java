package com.example.tourism;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class discover_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover_activity);
        ImageButton cairo=findViewById(R.id.Cairo);
        cairo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(), cairo.class);
                s1.putExtra("country","القاهره");
                startActivity(s1);
            }
        });
        ImageButton alexandria=findViewById(R.id.Alexandria);
        alexandria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),Alexandria.class);
                s1.putExtra("country","إسكندرية");
                startActivity(s1);
            }
        });
        ImageButton the_Shortest=findViewById(R.id.The_Shortest);
        the_Shortest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),The_Shortest.class);
                s1.putExtra("country","الأقصر");
                startActivity(s1);
            }
        });
        ImageButton aswan=findViewById(R.id.Aswan);
        aswan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),Aswan.class);
                s1.putExtra("country","اسوان");
                startActivity(s1);
            }
        });

    }
}
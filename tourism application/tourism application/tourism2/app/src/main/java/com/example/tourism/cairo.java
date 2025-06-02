package com.example.tourism;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class cairo extends AppCompatActivity {
    public String country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cairo);

        country=getIntent().getExtras().getString("country");
        ImageView a1=findViewById(R.id.imageView3);



        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","أهرامات الجيزه");
                startActivity(s1);
            }
        });
        ImageView a2=findViewById(R.id.imageView4);



        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","أبو الهول");
                startActivity(s1);
            }
        });
        ImageView a3=findViewById(R.id.imageView5);



        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","هرم سقارة المدرج");
                startActivity(s1);
            }
        });
        ImageView a4=findViewById(R.id.imageView6);


        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","برج القاهرة");
                startActivity(s1);
            }
        });
        ImageView a5=findViewById(R.id.imageView7);



        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","متحف المصري");
                startActivity(s1);
            }
        });
        ImageView a6=findViewById(R.id.imageView8);


        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","متحف ام كلثوم");
                startActivity(s1);
            }
        });

        ImageView a7=findViewById(R.id.imageView9);
        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","المتحف القبطي");
                startActivity(s1);
            }
        });
        ImageView a8=findViewById(R.id.imageView10);



        a8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","متحف الحضارة");
                startActivity(s1);
            }
        });
        ImageView a9=findViewById(R.id.imageView11);



        a9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","مسجد عمرو بن العاص");
                startActivity(s1);
            }
        });
        ImageView a10=findViewById(R.id.imageView12);



        a10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","جامع الأزهر");
                startActivity(s1);
            }
        });
        ImageView a11=findViewById(R.id.imageView13);



        a11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","الكنيسة المعلقة");
                startActivity(s1);
            }
        });
        ImageView a12=findViewById(R.id.imageView14);



        a12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","كنيسة القديسة بربارة");
                startActivity(s1);
            }
        });
        ImageView a13=findViewById(R.id.imageView15);

        a13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","الحديقة الدولية بالقاهرة");
                startActivity(s1);
            }
        });
        ImageView a14=findViewById(R.id.imageView16);



        a14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","حديقة الأسماك");
                startActivity(s1);
            }
        });
        ImageView a15=findViewById(R.id.imageView17);



        a15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),aboutPlace.class);
                s1.putExtra("country",country);
                s1.putExtra("place","حديقة الأزهر");
                startActivity(s1);
            }
        });
    }
}
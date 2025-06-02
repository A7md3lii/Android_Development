package com.example.tourism;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Coutact_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coutact__us);
        Button send=findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView your_name=findViewById(R.id.your_name);
                String name=your_name.getText().toString();

                TextView phone_number=findViewById(R.id.phone_number);
                String phone=phone_number.getText().toString();

                TextView email=findViewById(R.id.email);
                String Email=email.getText().toString();

                TextView Your_Question=findViewById(R.id.Your_Question);
                String question=Your_Question.getText().toString();

                Intent x=new Intent(Intent.ACTION_SEND);
                x.setType("text/plain");
                x.putExtra(Intent.EXTRA_TEXT,name+"\n"+phone+"\n"+Email+"\n"+question+"\n");
                startActivity(Intent.createChooser(x,"share via"));
            }
        });
        ImageButton call=findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x=new Intent(Intent.ACTION_CALL);
                x.setData(Uri.parse("tel: 01553017722"));
                startActivity(x);
            }
        });
    }
}
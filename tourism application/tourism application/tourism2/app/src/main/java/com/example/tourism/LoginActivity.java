package com.example.tourism;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private FirebaseDatabase dataBase;
    private DatabaseReference informationReference;
    String []passes;
    String []emails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dataBase=FirebaseDatabase.getInstance();
        informationReference=dataBase.getReference("accounts");

        SharedPreferences e = getSharedPreferences("currentUser", MODE_PRIVATE);
        if (e.getString("currentUser", null) == null) {

            getDataFromDataBase();

            Button google = findViewById(R.id.btnGoogle);
            google.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clicked_btn("https://accounts.google.com/servicelogin");
                }
            });

            Button facebook = findViewById(R.id.btnFacebook);
            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clicked_btn("https://www.facebook.com/");
                }
            });

            TextView btn=findViewById(R.id.textViewSignUp);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), RegisterActivity.class) );
                }
            });

            Button x = findViewById(R.id.btnlogin);
            x.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText mail = findViewById(R.id.inputEmail);
                    EditText pass = findViewById(R.id.inputPassword);
                    String email = mail.getText().toString();
                    String pss = pass.getText().toString();
                    if(email.length()==0|| pss.length()==0) {
                        Toast.makeText(getApplicationContext(),"missing field",Toast.LENGTH_SHORT).show();
                    }else{
                        if(available(email,pss)) {
                            SharedPreferences.Editor e = getSharedPreferences("currentUser", MODE_PRIVATE).edit();
                            e.putString("currentUser", email);
                            e.apply();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(),"incorrect password or email",Toast.LENGTH_SHORT).show();
                            mail.setText(null);
                            pass.setText(null);
                        }
                    }
                }
            });
        }
        else{
            Intent x = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(x);
        }

    }

    private void getDataFromDataBase() {
        informationReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                passes=new String[(int)snapshot.getChildrenCount()];
                emails=new String[(int)snapshot.getChildrenCount()];
                int i=0;
                for(DataSnapshot one:snapshot.getChildren()){
                    emails[i]=one.child("email").getValue().toString();
                    passes[i]=one.child("password").getValue().toString();
                    i++;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private boolean available(String email, String pss) {
        boolean found=false;
        if(emails.length>0){
            for(int i=0;i<emails.length;i++){
                if(emails[i].equalsIgnoreCase(email)){
                    if(passes[i].equals(pss))
                        found=true;
                }
            }
        }
        return found;
    }

    public void clicked_btn(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}
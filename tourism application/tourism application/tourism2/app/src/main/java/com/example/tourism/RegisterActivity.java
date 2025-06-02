package com.example.tourism;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    Button opngallery;
    ImageView mImageView;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    private FirebaseDatabase dataBase;
    private DatabaseReference informationReference;
    String mails[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dataBase=FirebaseDatabase.getInstance();
        informationReference=dataBase.getReference("accounts");

        getEmails();

        opngallery = findViewById(R.id.btngallery);
        mImageView = findViewById(R.id.imageView);
        opngallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){

                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions, PERMISSION_CODE);
                    }
                    else {

                        pickImageFromGallery();
                    }
                }
                else {
                    pickImageFromGallery();
                }

            }
        });

        TextView btn=findViewById(R.id.alreadyHaveAccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        Button tkcamera = findViewById(R.id.btntakephoto);
        tkcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        Button register = findViewById(R.id.btnregister);
        register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText usrname = findViewById(R.id.inputUsername);
                    EditText mail = findViewById(R.id.inputemail2);
                    EditText passw = findViewById(R.id.inputPassword);
                    EditText phon = findViewById(R.id.inputphone);

                    String username = usrname.getText().toString();
                    String email = mail.getText().toString();
                    String password = passw.getText().toString();
                    String phone = phon.getText().toString();

                    boolean found =false;
                    for(int i=0;i<mails.length;i++){
                        if(email.equalsIgnoreCase(mails[i])){
                            found=true;
                            break;
                        }
                    }

                    //String passwordVal = "^" + "(?=.*[a-zA-Z])" +  "(?=.*[@#$%^&+=])" + ".{4,}" + "$";
                    if (username.isEmpty()){
                        usrname.setError("Please enter USER NAME");
                        Toast.makeText(RegisterActivity.this, "Please enter USER NAME", Toast.LENGTH_SHORT).show();
                    }
                    else if (email.isEmpty()){
                        mail.setError("Please enter Email");
                        Toast.makeText(RegisterActivity.this, "Please enter Email", Toast.LENGTH_SHORT).show();
                    }else if(found){
                        mail.setError("the email is used!!");
                    }
                    else if (password.isEmpty()){
                        passw.setError("Please enter Password");
                        Toast.makeText(RegisterActivity.this, "Please enter Email", Toast.LENGTH_SHORT).show();
                    }
                    else if (password.length()<=8){
                        passw.setError("Password is too weak");
                        Toast.makeText(RegisterActivity.this, "Password is too weak", Toast.LENGTH_SHORT).show();
                    }
                    else if (phone.isEmpty()){
                        phon.setError("Please enter phone");
                        Toast.makeText(RegisterActivity.this, "Please enter phone", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        usrname.setError(null);
                        mail.setError(null);
                        passw.setError(null);
                        phon.setError(null);

                        addNewAccount(username, email, password, phone);
                        SharedPreferences.Editor e = getSharedPreferences("currentUser", MODE_PRIVATE).edit();
                        e.putString("currentUser", email);
                        e.apply();
                        Intent x = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(x);

                    }
                }

            });


    }
    public void addNewAccount(String userName,String email,String pass,String phone){
            String key = informationReference.push().getKey();
            informationReference.child(key).child("user name").setValue(userName);
            informationReference.child(key).child("email").setValue(email);
            informationReference.child(key).child("password").setValue(pass);
            informationReference.child(key).child("phone").setValue(phone);
    }

    public void getEmails(){

        informationReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mails=new String[(int)dataSnapshot.getChildrenCount()];
                int i=0;
                for(DataSnapshot one : dataSnapshot.getChildren()){
                    mails[i]=one.child("email").getValue().toString();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    pickImageFromGallery();
                }
                else {
                    Toast.makeText(this, "Permission denied..", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE ){

            mImageView.setImageURI(data.getData());
        }
    }
}

package com.example.tourism;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String currentUserEmail;

    private FirebaseStorage storage;
    private StorageReference storageReference;
    private FirebaseDatabase dataBase;
    private DatabaseReference informationReference;

    ImageView refresh;
    ImageButton discoverBtn;
    Button newPostBtn;

    String []aboutPost;
    String []postImgName;
    Bitmap []Images;
    int canMakechange;
    adapterForPosts adapt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences e=getSharedPreferences("currentUser",MODE_PRIVATE);
        currentUserEmail=e.getString("currentUser",null);

        storage=FirebaseStorage.getInstance();
        storageReference=storage.getReference();

        dataBase=FirebaseDatabase.getInstance();
        informationReference=dataBase.getReference("posts");

        refresh=findViewById(R.id.refresh);
        discoverBtn =findViewById(R.id.discoverBtn);
        newPostBtn =findViewById(R.id.newPostBtn);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canMakechange=1;
                showPosts();
                ListView postList=findViewById(R.id.postList);
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                postList.setVisibility(View.VISIBLE);
                postList.startAnimation(anim);
            }
        });
        discoverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent x= new Intent(getApplicationContext(), discover_activity.class);
                    startActivity(x);
               }
        });
        newPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x= new Intent(getApplicationContext(), postForm.class);
                startActivity(x);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.contacUs){
            Intent x=new Intent(getApplicationContext(), Coutact_Us.class);
            startActivity(x);
        }else if(item.getItemId()== R.id.logOut){
            SharedPreferences.Editor e = getSharedPreferences("currentUser", MODE_PRIVATE).edit();
            e.putString("currentUser",null);
            e.apply();
            Intent x=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(x);
        }
        return super.onOptionsItemSelected(item);
    }
    private void showPosts() {
        informationReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(canMakechange==1){
                    makeChange(dataSnapshot);
                    canMakechange=0;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void makeChange(DataSnapshot dataSnapshot){
        aboutPost=null;
        postImgName=null;
        Images=null;
        if(dataSnapshot.getChildrenCount()>0){

            aboutPost=new String[(int) dataSnapshot.getChildrenCount()];
            postImgName=new String[(int) dataSnapshot.getChildrenCount()];
            int i=0;
            for(DataSnapshot one : dataSnapshot.getChildren()){
                aboutPost[i]=one.child("about post").getValue().toString();
                postImgName[i]=one.child("post img").getValue().toString();
                i++;
            }
            Images=getImg(postImgName);
            ListView l = findViewById(R.id.postList);
            adapt = new adapterForPosts(getApplicationContext(), aboutPost, Images);
            l.setAdapter(adapt);

        }else
            Toast.makeText(getApplicationContext(),"there is no posts now!!",Toast.LENGTH_SHORT).show();

    }



    public Bitmap[] getImg(String []imgnames){

        Bitmap images[]=new Bitmap[imgnames.length];

        for(int i=0;i<imgnames.length;i++) {
            StorageReference imageRef = storage.getReference().child("images").child(imgnames[i]);
            int finalI = i;
            imageRef.getBytes(4096 * 4096).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                     Bitmap newImage= BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

                     images[finalI]=newImage;
                }
            });
        }
        return images;

    }
}
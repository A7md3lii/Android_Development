package com.example.tourism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class aboutPlace extends AppCompatActivity {

    private FirebaseStorage storage;
    private StorageReference storageReference;
    private FirebaseDatabase dataBase;
    private DatabaseReference informationReference;


    String country;
    String place;


    String []imagesName;
    Bitmap []images;

    String xPoint;
    String yPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_place);

        country=getIntent().getExtras().getString("country");
        place=getIntent().getExtras().getString("place");

        storage=FirebaseStorage.getInstance();
        storageReference=storage.getReference();
        dataBase=FirebaseDatabase.getInstance();
        informationReference=dataBase.getReference("places");

        showPlaceInfo();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aboutplacecard,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.maps){
            Intent a=new Intent(getApplicationContext(), MapsActivity.class);
            a.putExtra("x",xPoint);
            a.putExtra("y",yPoint);
            a.putExtra("country",country);
            a.putExtra("place",place);
            startActivity(a);
        }
        return super.onOptionsItemSelected(item);
    }

    private void showPlaceInfo() {
        informationReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                imagesName=new String[(int)(dataSnapshot.child(country).child(place).child("images").getChildrenCount())];
                String aboutPlace=dataSnapshot.child(country).child(place).child("info").getValue().toString();
                xPoint=dataSnapshot.child(country).child(place).child("location").child("x").getValue().toString();
                yPoint=dataSnapshot.child(country).child(place).child("location").child("y").getValue().toString();

                int i=0;
                for(DataSnapshot one : dataSnapshot.child(country).child(place).child("images").getChildren()){
                    imagesName[i]=one.getValue().toString();
                    i++;
                }
                images=new Bitmap[imagesName.length];
                images=getImg(imagesName);

                TextView text= findViewById(R.id.aboutPlace);
                text.setText(aboutPlace);

                ListView l=findViewById(R.id.placeImagesList);
                adapterForPlaces adapt=new adapterForPlaces(getApplicationContext(),images);
                l.setAdapter(adapt);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public Bitmap[] getImg(String []imgnames){

        Bitmap images[]=new Bitmap[imgnames.length];

        for(int i=0;i<imgnames.length;i++) {
            StorageReference imageRef = storage.getReference().child("images").child(country).child(place).child(imgnames[i]);
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

    /*public void makeChange(DataSnapshot dataSnapshot){
        if(dataSnapshot.getChildrenCount()>0){
            aboutPost=null;
            postImgName=null;
            Images=null;

            aboutPost=new String[(int) dataSnapshot.getChildrenCount()];
            postImgName=new String[(int) dataSnapshot.getChildrenCount()];
            int i=0;

            Images=getImg(postImgName);
            ListView l = findViewById(R.id.postList);
            adapt = new adapterForPosts(getApplicationContext(), aboutPost, Images);
            l.setAdapter(adapt);

        }else
            Toast.makeText(getApplicationContext(),"there is no posts now!!",Toast.LENGTH_SHORT).show();

    }*/

}
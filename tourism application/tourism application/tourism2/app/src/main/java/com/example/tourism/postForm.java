package com.example.tourism;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;*/

public class postForm extends AppCompatActivity {
    private ImageView postImg;
    public Uri postImgUri;
    public String postImgName;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private FirebaseDatabase dataBase;
    private DatabaseReference informationReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_form);

        postImg=findViewById(R.id.postPic);

        storage=FirebaseStorage.getInstance();
        storageReference=storage.getReference();

        dataBase=FirebaseDatabase.getInstance();
        informationReference=dataBase.getReference("posts");


        ImageButton back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(s1);
            }
        });

        ImageButton gallary=findViewById(R.id.photo);
        gallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x=new Intent(Intent.ACTION_PICK);
                x.setType("image/*");
                startActivityForResult(x,1);
            }
        });

        Button post=findViewById(R.id.post);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadPost();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1&&resultCode==RESULT_OK){
            Toast.makeText(this, "gallery", Toast.LENGTH_SHORT).show();
            postImgUri=data.getData();
            postImg.setImageURI(postImgUri);
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    private void uploadPost() {

        final ProgressDialog pd=new ProgressDialog(this);
        pd.setTitle("uploading Image....");
        pd.show();

        final String randomKey= UUID.randomUUID().toString();
        postImgName=randomKey+".jpg";
        StorageReference imgRef = storageReference.child("images/"+postImgName);
        imgRef.putFile(postImgUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        pd.dismiss();
                        Snackbar.make(findViewById(android.R.id.content),"image uploaded.", Snackbar.LENGTH_SHORT).show();

                        TextView text=findViewById(R.id.write);
                        String aboutPostText=text.getText().toString();
                        String key=informationReference.push().getKey();
                        informationReference.child(key).child("about post").setValue(aboutPostText);
                        informationReference.child(key).child("post img").setValue(postImgName);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(getApplicationContext(),"Faild to upload",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        double progresspercent = (100.00*snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                        pd.setMessage("uploading: "+ (int)progresspercent +"%");
                    }
                });

    }

}
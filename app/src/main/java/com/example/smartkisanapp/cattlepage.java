package com.example.smartkisanapp;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.net.URI;
import java.util.UUID;

public class cattlepage extends AppCompatActivity {

    ImageView profilepic;
    public Uri imageuri;
    public FirebaseStorage storage;
    public StorageReference storageReference;
    private Button uploadbutton;

    //Firebase
    private FirebaseDatabase rootnode;
    private DatabaseReference reference,referencegir;

    private TextInputEditText cowname,cowage,litres,diseaseinfo,ownerno;
    private Button postbutton;

    String[] items = {"GIR", "RED SINDHI", "SAHIWAL", "HALLIKAR", "KHILLARI"};
    AutoCompleteTextView autocompletetext;
    ArrayAdapter<String> adapteritems;

    private final int GALLERY_REQ_CODE=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cattlepage);

        autocompletetext = findViewById(R.id.cattlenames);
        cowname=findViewById(R.id.cowname);
        cowage=findViewById(R.id.cowage);
        litres=findViewById(R.id.litres);
        diseaseinfo=findViewById(R.id.diseaseinfo);
        postbutton=findViewById(R.id.postbutton);
        ownerno=findViewById(R.id.ownerno);




        profilepic = findViewById(R.id.profilepic);
        uploadbutton=findViewById(R.id.uploadbutton);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();


        adapteritems = new ArrayAdapter<String>(this, R.layout.dropdown_cattle, items);
        autocompletetext.setAdapter(adapteritems);

        autocompletetext.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(cattlepage.this, "Cattle: " + item, Toast.LENGTH_SHORT).show();



                postbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HomePage();

                        rootnode=FirebaseDatabase.getInstance();
                        reference=rootnode.getReference("cow");

                        //Get Values
                        String name = cowname.getText().toString();
                        String cowtype = item;
                        String medicalinfo = diseaseinfo.getText().toString();
                        String age = cowage.getText().toString();
                        String milk = litres.getText().toString();
                        String ownernumber = ownerno.getText().toString();

                        cowhelperclass helperClass= new cowhelperclass(cowtype,name,age,milk,medicalinfo,ownernumber);

                        reference.child(ownernumber).setValue(helperClass);
                        //referencegir=reference.child(cowtype);
                        //referencegir.child(ownernumber).setValue(helperClass);

                        Toast.makeText(cattlepage.this, "Information Uploaded", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nGetContent.launch("image/*");
            }
        });

        uploadbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadPicture();
            }
        });



    }




    ActivityResultLauncher<String> nGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    if (result != null)
                    {
                        profilepic.setImageURI(result);
                        imageuri=result;
                    }
                }
            });





    public void uploadPicture() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Uploading Image....");
        pd.show();

        final String randomkey = UUID.randomUUID().toString();
        StorageReference riversRef = storageReference.child("Images/" + randomkey);

        riversRef.putFile(imageuri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        pd.dismiss();
                        Snackbar.make(findViewById(android.R.id.content),"Image Uploaded",Snackbar.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(getApplicationContext(), "Failed to Upload", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot tasksnapshot) {
                        double progressPercent = (100.00 * tasksnapshot.getBytesTransferred() / tasksnapshot.getTotalByteCount());
                        pd.setMessage("Percentage: " + (int) progressPercent + "%");
                    }
                });

    }

    public void HomePage()
    {
        Intent intent= new Intent(this,HomePage.class);
        startActivity(intent);
    }

}

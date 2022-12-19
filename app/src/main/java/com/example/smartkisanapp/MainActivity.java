package com.example.smartkisanapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private Button button,signinbutton;
    private TextInputEditText loginusername,loginpass;    //Email and Password
    private FirebaseAuth mAuth;                             //Firebase
    private FirebaseDatabase rootnode;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Fetching the UI to Java for using it in fuctions

        button = findViewById(R.id.button);
        signinbutton = findViewById(R.id.signinbutton);
        loginusername = findViewById(R.id.loginusername);
        loginpass = findViewById(R.id.loginpass);

        //Create Instance for Firebase
        mAuth = FirebaseAuth.getInstance();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isUser();
            }
        });


        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signinpage();

            }
        });
    }

//


    public void isUser()
    {

        reference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://smartkisanapp-default-rtdb.firebaseio.com");
        String userenterUN=loginusername.getText().toString();
        String userenterpass=loginpass.getText().toString();

        reference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(userenterUN))
                {
                    final String getPass= snapshot.child(userenterUN).child("password").getValue(String.class);

                    if(getPass.equals(userenterpass)){

                        Toast.makeText(MainActivity.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                        homepage();


//                         String namefromDB=snapshot.child(userenterUN).child("name").getValue(String.class);
//                         String agefromDB=snapshot.child(userenterUN).child("age").getValue(String.class);
//                         String addressfromDB=snapshot.child(userenterUN).child("address").getValue(String.class);
//                         String numberfromDB=snapshot.child(userenterUN).child("phoneno").getValue(String.class);
//
//                         Intent intent = new Intent(getApplicationContext(),profilepage.class);
//
//                         intent.putExtra("name",namefromDB);
//                         intent.putExtra("age",agefromDB);
//                         intent.putExtra("address",addressfromDB);
//                         intent.putExtra("phoneno",numberfromDB);
//
//                         startActivity(intent);



                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Wrong Username", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }




    public void homepage()
    {
//        Intent intent= new Intent(this,HomePage.class);
//        startActivity(intent);
        takeinfo();
        Intent intent = new Intent(getApplicationContext(),HomePage.class);
        startActivity(intent);


    }
    public void signinpage()
    {
        Intent intent= new Intent(this,signin_page.class);
        startActivity(intent);
    }

    public void takeinfo()
    {
        reference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://smartkisanapp-default-rtdb.firebaseio.com");
        String userenterUN=loginusername.getText().toString();
        String userenterpass=loginpass.getText().toString();

        if(reference.child("users").equals(userenterUN))
        {
            String namefromDB=reference.child(userenterUN).child("name").toString();
            String agefromDB=reference.child(userenterUN).child("age").toString();
            String addressfromDB=reference.child(userenterUN).child("address").toString();
            String numberfromDB=reference.child(userenterUN).child("phoneno").toString();

            Intent intent = new Intent(getApplicationContext(),profilepage.class);

            intent.putExtra("name",namefromDB);
            intent.putExtra("age",agefromDB);
            intent.putExtra("address",addressfromDB);
            intent.putExtra("phoneno",numberfromDB);

            startActivity(intent);




        }

    }
}
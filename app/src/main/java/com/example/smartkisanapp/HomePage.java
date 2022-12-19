package com.example.smartkisanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomePage extends AppCompatActivity {

    private Button addbutton;
    private Button profilepbutton;
    private FirebaseDatabase rootnode;
    private DatabaseReference reference;
    private Button buybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        //Fetching the UI to Java for using it in fuctions
        addbutton=findViewById(R.id.addbutton);
        profilepbutton=findViewById(R.id.profilepbutton);
        buybutton=findViewById(R.id.buybutton);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sellitems();
            }
        });

        buybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Buy();

            }
        });

        profilepbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profilePage();



            }
        });
    }
    public void sellitems()
    {
        Intent intent= new Intent(this,addtasks.class);
        startActivity(intent);

    }

    public void profilePage()
    {
        Intent intent = new Intent(this, profilepage.class);
        startActivity(intent);


    }
    public void Buy()
    {
        Intent intent = new Intent(this, BuyActivity2.class);
        startActivity(intent);

    }
}
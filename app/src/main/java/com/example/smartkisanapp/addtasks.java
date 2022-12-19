package com.example.smartkisanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addtasks extends AppCompatActivity {

    private Button machinary;
    private Button crops;
    private Button cow;
    private Button horse;
    private Button goat;
    private Button buffalo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtasks);

        cow=findViewById(R.id.cow);
        machinary=findViewById(R.id.postbutton);
        crops=findViewById(R.id.crops);
        horse=findViewById(R.id.horse);
        goat=findViewById(R.id.goat);
        buffalo=findViewById(R.id.buffalo);


        cow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cattle_window();
            }
        });

        machinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                machinary_window();
            }
        });

        crops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crop_window();
            }
        });

        horse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horse_window();
            }
        });

        goat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goat_window();
            }
        });

        buffalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buffalo_window();
            }
        });
    }
    public void cattle_window()
    {
        Intent intent= new Intent(this,cattlepage.class);
        startActivity(intent);
    }

    public void machinary_window()
    {
        Intent intent= new Intent(this,machinary.class);
        startActivity(intent);
    }

    public void crop_window()
    {
        Intent intent= new Intent(this,croppage.class);
        startActivity(intent);
    }
    public void horse_window()
    {
        Intent intent= new Intent(this,horsepage.class);
        startActivity(intent);
    }
    public void goat_window()
    {
        Intent intent= new Intent(this,goatpage.class);
        startActivity(intent);
    }
    public void buffalo_window()
    {
        Intent intent= new Intent(this,buffalopage.class);
        startActivity(intent);
    }
}
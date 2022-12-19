package com.example.smartkisanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class profilepage extends AppCompatActivity {

    private TextInputEditText logfullname,logsignage,logsignaddress,logsignMN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
        logfullname= findViewById(R.id.logfullname);
        logsignage=findViewById(R.id.logsignage);
        logsignaddress=findViewById(R.id.logsignaddress);
        logsignMN=findViewById(R.id.logsignMN);


        showallUserdata();





    }

    private void showallUserdata()
    {
        Intent intent = getIntent();
        String pro_name=intent.getStringExtra("name");
        String pro_age=intent.getStringExtra("age");
        String pro_address=intent.getStringExtra("address");
        String pro_number=intent.getStringExtra("phoneno");


        logfullname.setText(pro_name);
        logsignage.setText(pro_age);
        logsignaddress.setText(pro_address);
        logsignMN.setText(pro_number);


    }
}
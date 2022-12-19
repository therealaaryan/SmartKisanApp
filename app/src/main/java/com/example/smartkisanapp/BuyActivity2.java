package com.example.smartkisanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuyActivity2 extends AppCompatActivity {
    private Button Cow_buy_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy2);

        Cow_buy_button=findViewById(R.id.Cow_buy_button);

        Cow_buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCow();
            }
        });
    }
    public void openCow(){
        Intent intent = new Intent(this, Cow_buy_button.class);
        startActivity(intent);
    }
}
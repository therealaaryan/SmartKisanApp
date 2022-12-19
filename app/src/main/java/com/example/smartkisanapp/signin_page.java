package com.example.smartkisanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signin_page extends AppCompatActivity {

    private Button signinmain;
    private TextInputEditText fullname,signage,signaddress,signMN,signusername,signPass,signCPass;
    private FirebaseAuth mAuth;
    private FirebaseDatabase rootnode;
    private DatabaseReference reference,reference1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_page);

        fullname= findViewById(R.id.fullname);
        signage= findViewById(R.id.signage);
        signaddress= findViewById(R.id.signaddress);
        signMN= findViewById(R.id.signMN);
        signusername=findViewById(R.id.signusername);
        signPass= findViewById(R.id.signPass);
        signCPass= findViewById(R.id.signCPass);


        signinmain=findViewById(R.id.signinmain);

        signinmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomePage();

                //Firebase
                rootnode=FirebaseDatabase.getInstance();
                reference=rootnode.getReference("users");


                //Get Values
                String name = fullname.getText().toString();
                String age = signage.getText().toString();
                String address = signaddress.getText().toString();
                String username = signusername.getText().toString();
                String phoneno = signMN.getText().toString();
                String password = signPass.getText().toString();
                String confirmpass = signCPass.getText().toString();

                UserHelperClass helperClass= new UserHelperClass(name,age,address,username,phoneno,password,confirmpass);

                reference.child(username).setValue(helperClass);
            }
        });

    }

    public void HomePage()
    {
        Intent intent= new Intent(this,HomePage.class);
        startActivity(intent);
    }


}
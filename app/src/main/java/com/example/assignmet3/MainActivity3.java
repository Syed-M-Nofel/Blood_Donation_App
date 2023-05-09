package com.example.assignmet3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    EditText name,city,contact,bloodgrp;
    DBHelper DB;
    Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name = findViewById(R.id.editTextTextPersonName);
        city = findViewById(R.id.editTextTextPersonName2);
        contact = findViewById(R.id.editTextTextPersonName3);
        bloodgrp = findViewById(R.id.editTextTextPersonName4);
        update = findViewById(R.id.button);
        DB = new DBHelper(this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String cityTXT = city.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = bloodgrp.getText().toString();

                Boolean checkupdatedata = DB.updateUserData(nameTXT,cityTXT, contactTXT, dobTXT);
                if(checkupdatedata==true)
                    Toast.makeText(MainActivity3.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity3.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });


    }
}
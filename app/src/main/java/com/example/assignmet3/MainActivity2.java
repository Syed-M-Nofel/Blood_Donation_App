package com.example.assignmet3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText name,city,contact,bloodgrp;
    DBHelper DB;
    Button insert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.editTextTextPersonName);
        city = findViewById(R.id.editTextTextPersonName2);
        contact = findViewById(R.id.editTextTextPersonName3);
        bloodgrp = findViewById(R.id.editTextTextPersonName4);
        insert = findViewById(R.id.button);

        DB = new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String cityTXT = city.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = bloodgrp.getText().toString();
                Log.d("MainActivity2", "name=" + nameTXT + ", city=" + cityTXT + ", contact=" + contactTXT + ", dob=" + dobTXT);

                Boolean checkinsertdata = DB.insertUserData(nameTXT, cityTXT, contactTXT, dobTXT);
                if (checkinsertdata == true)
                    Toast.makeText(MainActivity2.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity2.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });

    }
}
package com.example.assignmet3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    EditText name,city,contact,bloodgrp;
    DBHelper DB;
    Button delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        name = findViewById(R.id.editTextTextPersonName);
        city = findViewById(R.id.editTextTextPersonName2);
        contact = findViewById(R.id.editTextTextPersonName3);
        bloodgrp = findViewById(R.id.editTextTextPersonName4);
        delete = findViewById(R.id.button);
        DB = new DBHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deleteData(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(MainActivity4.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity4.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
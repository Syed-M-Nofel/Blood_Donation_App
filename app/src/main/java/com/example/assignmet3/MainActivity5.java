package com.example.assignmet3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    DBHelper DB;
    Button view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        view = findViewById(R.id.button);
        DB = new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getData();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity5.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("city :"+res.getString(1)+"\n");
                    buffer.append("Contact :"+res.getString(2)+"\n");
                    buffer.append("Blood group :"+res.getString(3)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity5.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });

    }
}
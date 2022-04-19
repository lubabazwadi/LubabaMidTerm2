package com.example.lubaba_midterm_22022;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button insert = (Button) findViewById(R.id.insert);
        EditText id = (EditText) findViewById(R.id.id);
        EditText name = (EditText) findViewById(R.id.name);
        EditText surname = (EditText) findViewById(R.id.surname);
        EditText national = (EditText) findViewById(R.id.national);
        final DatabaseHelper MyDB = new DatabaseHelper(this);

        insert.setOnClickListener(e -> {
            try {
                String id_val = id.getText().toString();
                String name_val = name.getText().toString();
                String email_val = surname.getText().toString();
                String phone_val = national.getText().toString();

                if (id_val.isEmpty() || name_val.isEmpty() || email_val.isEmpty() || phone_val.isEmpty())
                    Toast.makeText(MainActivity.this, "please fill the fields", Toast.LENGTH_LONG).show();
                else {
                    MyDB.addData(id_val, name_val, email_val, phone_val);
                    Log.d("Lubaba", "after adding value");
                    Toast.makeText(MainActivity.this, "Successful Insert", Toast.LENGTH_LONG).show();
                }
            } catch (Exception err) {
                count = 1;
                Toast.makeText(MainActivity.this, "Unsuccessful Insert please insert all necessary data", Toast.LENGTH_LONG).show();
            }
        });

        Button mainButton3 = (Button) findViewById(R.id.activity1);
        Button mainButton4 = (Button) findViewById(R.id.activity3);
        mainButton3.setOnClickListener(e -> startActivity(new Intent(MainActivity.this, Splash.class)));
        mainButton4.setOnClickListener(e -> startActivity(new Intent(MainActivity.this, MainActivity2.class)));
    }
}
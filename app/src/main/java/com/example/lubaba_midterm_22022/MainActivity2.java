package com.example.lubaba_midterm_22022;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    int delnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DatabaseHelper db = new DatabaseHelper(this);
        Button go1 = (Button) findViewById(R.id.button5);
        go1.setOnClickListener(e -> { startActivity(new Intent(MainActivity2.this, MainActivity.class)); });

        Button view = (Button) findViewById(R.id.view);
        Button delete = (Button) findViewById(R.id.deletebttn);
        EditText deleteT = (EditText) findViewById(R.id.delete);

        view.setOnClickListener(e -> {
            Cursor cur = db.getListContents();
            StringBuffer buffer = new StringBuffer();
            while (cur.moveToNext()) {
                buffer.append("ID: " + cur.getString(0) + "\n");
                buffer.append("Name: " + cur.getString(1) + "\n");
                buffer.append("Surname: " + cur.getString(2) + "\n");
                buffer.append("National ID: " + cur.getString(3) + "\n\n");
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
            builder.setCancelable(true); // a dialog box that can be closed
            builder.setTitle("All Data");
            builder.setMessage(buffer.toString());
            builder.show();
            Toast.makeText(MainActivity2.this, "Successful View", Toast.LENGTH_LONG).show();
        });

        delete.setOnClickListener(e -> {
            String textdel = deleteT.getText().toString();
            if (db.Delete(textdel)) {
                delnum++;
                Toast.makeText(MainActivity2.this, delnum + "Records Deleted", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(MainActivity2.this, delnum + "Records not exist", Toast.LENGTH_LONG).show();
        });
    }
}
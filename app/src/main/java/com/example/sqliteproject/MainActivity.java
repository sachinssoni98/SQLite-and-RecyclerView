package com.example.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, age, city;
    Button submitBtn, searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= findViewById(R.id.name);
        age= findViewById(R.id.age);
        city= findViewById(R.id.city);
        submitBtn= findViewById(R.id.submit);
        searchBtn= findViewById(R.id.search);
        submitBtn.setOnClickListener(this::sendData);
        searchBtn.setOnClickListener(this::openSearchActivity);
    }

    private void openSearchActivity(View view) {
        Intent intent= new Intent(this,SearchActivity.class);
        startActivity(intent);
    }

    private void sendData(View view) {
        String n= name.getText().toString();
        String a= age.getText().toString();
        String c= city.getText().toString();
        SqliteDataHandler sqliteDataHandler= new SqliteDataHandler(this);
        String response=sqliteDataHandler.addRecord(n,a,c);
        name.setText("");
        age.setText("");
        city.setText("");
        Toast.makeText(this,response, Toast.LENGTH_SHORT).show();
    }


}
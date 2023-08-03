package com.example.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    EditText editText;
    Button searchBtn, searchAllBtn;
    ArrayList<Data> al;
    RecyclerView recyclerView;
    RecyclerViewAdapterClass recyclerViewAdapterClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        editText= findViewById(R.id.editText);
        searchBtn= findViewById(R.id.button);
        searchAllBtn= findViewById(R.id.searchAll);
        searchBtn.setOnClickListener(this::show);
        searchAllBtn.setOnClickListener(this::showAllData);
        recyclerView= findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

    }

    private void show(View view) {
        String n="";
        if(editText.getText()!=null){
            n= editText.getText().toString();
        }
        SqliteDataHandler dbHandler = new SqliteDataHandler(this);
        Cursor cursor= dbHandler.getData(n);
        al= new ArrayList<>();
        while(cursor.moveToNext()){
            Data data= new Data(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            al.add(data);
        }
        recyclerViewAdapterClass= new RecyclerViewAdapterClass(al);
        recyclerView.setAdapter(recyclerViewAdapterClass);
    }

    public void showAllData(View view){
        SqliteDataHandler dataHandler= new SqliteDataHandler(this);
        Cursor cursor= dataHandler.getAllData();
        al= new ArrayList<>();
        while(cursor.moveToNext()){
            Data allData= new Data(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            al.add(allData);
        }
        recyclerViewAdapterClass= new RecyclerViewAdapterClass(al);
        recyclerView.setAdapter(recyclerViewAdapterClass);
    }
}
package com.example.sqliteproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;

public class SqliteDataHandler extends SQLiteOpenHelper {

    private static final String dbname= "form";
    private static final String tablename="person";
    public SqliteDataHandler(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry= "create table "+tablename+" (id integer primary key autoincrement, name varchar2, age varchar2, city varchar2)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists "+tablename);
        onCreate(sqLiteDatabase);
    }

    public String addRecord(String name, String age, String city){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("age", age);
        cv.put("city",city);
         long res= db.insert(tablename,null, cv);
         if(res==-1){
             return "Failed";
         }else{
             return "Successfully inserted";
         }
    }

    public Cursor getData(String name) {
        SQLiteDatabase db= this.getReadableDatabase();
        String qry="select * from "+tablename+ " where name ='"+name+"'";
        return db.rawQuery(qry,null);
    }

    public Cursor getAllData(){
        SQLiteDatabase db= this.getReadableDatabase();
        String qry= "select * from "+tablename;
        return db.rawQuery(qry,null);
    }
}

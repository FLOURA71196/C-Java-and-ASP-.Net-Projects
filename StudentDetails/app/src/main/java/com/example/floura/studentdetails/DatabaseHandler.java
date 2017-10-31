package com.example.floura.studentdetails;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table StudentDetails(regno integer primary key, name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists StudentDetails");
        onCreate(db);
    }

    /***
     * to add details to the Database
     * @param regno = Student Register Number
     * @param name = Student Name
     */

    public void addDetails(int regno,String name){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("regno",regno);
        contentValues.put("name",name);
        sqLiteDatabase.insert("StudentDetails",null,contentValues);
        sqLiteDatabase.close();
    }

    public String displayDetails(){
        String regno,name;
        StringBuilder content = new StringBuilder();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from StudentDetails",null);
        while (cursor.moveToNext()){
            regno = cursor.getString(0);
            name = cursor.getString(1);
            content.append("Regno : "+regno+" Student Name : "+name+"\n");
        }
        sqLiteDatabase.close();
        return content.toString();
    }

    public void deleteDetails(){
        getWritableDatabase().delete("StudentDetails","name = ?",new String[]{"Floura"});
    }

    public void updateDetails(){
        ContentValues contentValues = new ContentValues();
        contentValues.put("regno",123);
        getWritableDatabase().update("StudentDetails",contentValues,"name = ?",new String[]{"Bobzee"});
    }
}

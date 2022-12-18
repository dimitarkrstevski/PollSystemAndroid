package com.example.proektandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Project.db";
    public static final String COLUMN_QUESTIONS = "questions";
    public static final String COLUMN_POLL = "poll";
    public static final String COLUMN_POLL2 = "poll2";
    public static final String COLUMN_POLL3 = "poll3";


    public DBHelper(Context context) {

        super(context, "Project.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB){
            // MyDB.execSQL("create Table role(id INTEGER primary key, Name TEXT)");
            MyDB.execSQL("create Table users(id INTEGER primary key, Name TEXT, Surname TEXT, Email TEXT, Username TEXT, Password TEXT, role_id)");
            MyDB.execSQL("create Table poll(id INTEGER primary key, Question TEXT, Answer1 TEXT, Answer2 TEXT, Answer3 TEXT, Answer4 TEXT)");
            MyDB.execSQL("create Table poll2(id INTEGER primary key, Question2 TEXT, Answer21 TEXT, Answer22 TEXT, Answer23 TEXT, Answer24 TEXT)");
            MyDB.execSQL("create Table poll3(id INTEGER primary key, Question3 TEXT, Answer31 TEXT, Answer32 TEXT, Answer33 TEXT, Answer34 TEXT)");
            // MyDB.execSQL("create Table voting(id INTEGER primary key, Time TIME)");
            // MyDB.execSQL("create Table questions(question TEXT primary key)");
            // MyDB.execSQL("create Table answers(answer TEXT primary key)");
            MyDB.execSQL("create Table location(id INTEGER primary key, users_id, voting_id)");
            MyDB.execSQL("create Table selectedRadioButton(id INTEGER primary key, NameRadio TEXT)");
            MyDB.execSQL("create Table timer(id INTEGER primary key, time TIME)");
            // MyDB.execSQL("create Table userAnswers(id INTEGER primary key, user_id, answers_id, location_id)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int ii){
            MyDB.execSQL("drop Table if exists users");
            MyDB.execSQL("drop Table if exists poll");
            //MyDB.execSQL("drop Table if exists selectRadioButton");
            MyDB.execSQL("drop Table if exists poll2");
            MyDB.execSQL("drop Table if exists poll3");
    }

    public Boolean insertData(String Name, String Surname, String Email, String Username, String Password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", Name);
        contentValues.put("Surname", Surname);
        contentValues.put("Email", Email);
        contentValues.put("Username", Username);
        contentValues.put("Password", Password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1){
            return false;
        }
        else
        {
            return true;
        }
    }
    // za tabela poll
    public Boolean insertData2(String Question, String Answer1, String Answer2, String Answer3, String Answer4 ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put ("Question", Question);
        contentValues.put ("Answer1", Answer1);
        contentValues.put ("Answer2", Answer2);
        contentValues.put ("Answer3", Answer3);
        contentValues.put ("Answer4", Answer4);
        long result = MyDB.insert("poll",null, contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    // za tabela poll2
    public Boolean insertData3(String Question2, String Answer21, String Answer22, String Answer23, String Answer24 ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put ("Question2", Question2);
        contentValues.put ("Answer21", Answer21);
        contentValues.put ("Answer22", Answer22);
        contentValues.put ("Answer23", Answer23);
        contentValues.put ("Answer24", Answer24);
        long result = MyDB.insert("poll2",null, contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    // za tabela poll3
    public Boolean insertData4(String Question3, String Answer31, String Answer32, String Answer33, String Answer34 ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put ("Question3", Question3);
        contentValues.put ("Answer31", Answer31);
        contentValues.put ("Answer32", Answer32);
        contentValues.put ("Answer33", Answer33);
        contentValues.put ("Answer34", Answer34);
        long result = MyDB.insert("poll3",null, contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getdata(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from poll", null);
        return cursor;
    }
    public Cursor getdata3(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from poll2", null);
        return cursor;
    }
    public Cursor getdata4(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from poll3", null);
        return cursor;
    }



    public Cursor getdataRadioButton(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from selectedRadioButton", null);
        return cursor;
    }


    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username =?", new String[] {username});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?  and password = ?", new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }



}

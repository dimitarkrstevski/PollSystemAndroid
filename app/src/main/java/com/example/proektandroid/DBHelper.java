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
    public static final String COLUMN_ANSWERS = "answers";

    public DBHelper(Context context) {

        super(context, "Project.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB){
            // MyDB.execSQL("create Table role(id INTEGER primary key, Name TEXT)");
            MyDB.execSQL("create Table users(id INTEGER primary key, Name TEXT, Surname TEXT, Email TEXT, Username TEXT, Password TEXT, role_id)");
            MyDB.execSQL("create Table poll(id INTEGER primary key, Question TEXT, Answer1 TEXT, Answer2 TEXT, Answer3 TEXT, Answer4 TEXT)");
            // MyDB.execSQL("create Table voting(id INTEGER primary key, Time TIME)");
            // MyDB.execSQL("create Table questions(question TEXT primary key)");
            // MyDB.execSQL("create Table answers(answer TEXT primary key)");
            MyDB.execSQL("create Table location(id INTEGER primary key, users_id, voting_id)");
            // MyDB.execSQL("create Table userAnswers(id INTEGER primary key, user_id, answers_id, location_id)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int ii){
            MyDB.execSQL("drop Table if exists users");
            MyDB.execSQL("drop Table if exists poll");
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
    public Cursor getdata(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from poll", null);
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

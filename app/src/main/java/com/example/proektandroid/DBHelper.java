package com.example.proektandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Project.db";

    public DBHelper(Context context) {
        super(context, "Project.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB){
            MyDB.execSQL("create Table role(id INTEGER primary key, Name TEXT)");
            MyDB.execSQL("create Table users(id INTEGER primary key, Name TEXT, Surname TEXT, Email TEXT, Username TEXT, Password TEXT, role_id)");
            MyDB.execSQL("create Table voting(id INTEGER primary key, Time TIME)");
            MyDB.execSQL("create Table questions(id INTEGER primary key, voiting_id, question TEXT)");
            MyDB.execSQL("create Table answers(id INTEGER primary key, questions_id, answer TEXT, isTrue BOOL)");
            MyDB.execSQL("create Table location(id INTEGER primary key, users_id, voting_id)");
            MyDB.execSQL("create Table userAnswers(id INTEGER primary key, user_id, answers_id, location_id)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1){
            MyDB.execSQL("drop Table if exists users");
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

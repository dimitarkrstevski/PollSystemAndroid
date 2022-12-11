package com.example.proektandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Userlist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList <String> question, answer1, answer2, answer3, answer4;
    DBHelper DB;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        DB = new DBHelper(this);
        question = new ArrayList<>();
        answer1 = new ArrayList<>();
        answer2 = new ArrayList<>();
        answer3 = new ArrayList<>();
        answer4 = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleviewer);
        adapter = new MyAdapter(this, question, answer1, answer2, answer3, answer4);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata()
    {
        Cursor cursor = DB.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(this, "Нема записи!", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext()){
                question.add(cursor.getString(0));
                answer1.add(cursor.getString(1));
                answer2.add(cursor.getString(2));
                answer3.add(cursor.getString(3));
                answer4.add(cursor.getString(4));
            }

        }
    }
}
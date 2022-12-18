package com.example.proektandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Userlist3 extends AppCompatActivity {

    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private CountDownTimer countDownTimer;
    private long timeleftinMillis;

    RecyclerView recyclerView;
    ArrayList <String> question3, answer31, answer32, answer33, answer34;
    DBHelper DB;
    MyAdapter3 adapter3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist3);


        DB = new DBHelper(this);
        question3 = new ArrayList<>();
        answer31 = new ArrayList<>();
        answer32 = new ArrayList<>();
        answer33 = new ArrayList<>();
        answer34 = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView3);
        adapter3 = new MyAdapter3(this, question3, answer31, answer32, answer33, answer34);
        recyclerView.setAdapter(adapter3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();


    }

    private void displaydata()
    {
        Cursor cursor = DB.getdata4();
        if(cursor.getCount()==0){
            Toast.makeText(this, "Нема записи!", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext()){
                question3.add(cursor.getString(1));
                answer31.add(cursor.getString(2));
                answer32.add(cursor.getString(3));
                answer33.add(cursor.getString(4));
                answer34.add(cursor.getString(5));
            }
            timeleftinMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();

        }
    }

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeleftinMillis, 1000) {
            @Override
            public void onTick(long l) {
                timeleftinMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeleftinMillis = 0;
                updateCountDownText();
            }
        }.start();
    }
    private void updateCountDownText(){
        int minutes = (int)(timeleftinMillis / 1000) / 60;
        int seconds = (int)(timeleftinMillis/1000) % 60;
        String timeFormated = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(countDownTimer != null){
            countDownTimer.cancel();
        }
    }
}
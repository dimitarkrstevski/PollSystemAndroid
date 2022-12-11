package com.example.proektandroid;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        DB = new DBHelper(this);

        TextView btn = findViewById(R.id.moiGlasanja);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(UserActivity.this, UserRezultatiGlasanjeActivity.class));
            }
        });

        TextView btn2 = findViewById(R.id.korisnikLogout);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this, LogInActivity.class));
            }
        });

        TextView btn3 = findViewById(R.id.buttonGlasanjeUser);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this, Userlist.class));
            }
        });



    }
}
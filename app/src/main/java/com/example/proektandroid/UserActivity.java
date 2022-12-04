package com.example.proektandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


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
    }
}
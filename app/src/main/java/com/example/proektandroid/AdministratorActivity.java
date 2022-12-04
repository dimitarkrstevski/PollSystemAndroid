package com.example.proektandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdministratorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);


        TextView btn = findViewById(R.id.btnNovoGlasanje);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(AdministratorActivity.this, AdministratorGlasanjeActivity.class));
            }
        });


        TextView btn2 = findViewById(R.id.administratorLogOut);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdministratorActivity.this, LogInActivity.class));
            }
        });



    }
}
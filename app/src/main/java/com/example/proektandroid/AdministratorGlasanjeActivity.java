package com.example.proektandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AdministratorGlasanjeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_glasanje);



        TextView btn = findViewById(R.id.btnStartGlasanje);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(AdministratorGlasanjeActivity.this, "Гласањето е Започнато!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdministratorGlasanjeActivity.this, AdministratorActivity.class));
            }
        });

        TextView btn1 = findViewById(R.id.btnSendNotifikacija);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdministratorGlasanjeActivity.this, "Успешно Испратена Нотификација!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
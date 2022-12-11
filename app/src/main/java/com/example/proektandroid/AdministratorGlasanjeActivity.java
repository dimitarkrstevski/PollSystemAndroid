package com.example.proektandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class AdministratorGlasanjeActivity extends AppCompatActivity {


    Date setVremeGlasanje;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_glasanje);




        TextView btn1 = findViewById(R.id.btnSendNotifikacija);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdministratorGlasanjeActivity.this, "Успешно Испратена Нотификација!", Toast.LENGTH_SHORT).show();

            }
        });

        TextView btn2 = findViewById(R.id.btnVnesiPrasanja);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(AdministratorGlasanjeActivity.this, VnesiPrasanjaActivity.class));
            }
        });

        TextView btn3 = findViewById(R.id.btnStartGlasanje);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(AdministratorGlasanjeActivity.this, "Гласањето е Започнато!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdministratorGlasanjeActivity.this, AdministratorActivity.class));
            }



        });




    }
}
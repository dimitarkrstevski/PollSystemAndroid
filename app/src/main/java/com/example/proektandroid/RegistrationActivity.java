package com.example.proektandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText name, surname, email, username, password;
    Button btnRegister;
    TextView alreadyHaveAcc;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = (EditText)findViewById(R.id.inputName);
        surname = (EditText)findViewById(R.id.inputSurrname);
        email = (EditText)findViewById(R.id.inputEmail);
        username = (EditText)findViewById(R.id.inputUsername);
        password = (EditText)findViewById(R.id.inputPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        alreadyHaveAcc = (TextView)findViewById(R.id.alreadyHaveAcc);
        DB = new DBHelper(this);
        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String Name = name.getText().toString();
                String surName = surname.getText().toString();
                String Email = email.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(Name.equals("")||surName.equals("")||Email.equals("")||user.equals("") || pass.equals("")){
                    Toast.makeText(RegistrationActivity.this, "Внесете ги вашите податоци!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuser = DB.checkusername(Name);
                    if (checkuser == false) {
                        Boolean insert = DB.insertData(Name, surName, Email, user, pass);
                        if (insert == true) {
                            Toast.makeText(RegistrationActivity.this, "Успешно Регистриран Корисник!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegistrationActivity.this, "Неуспешна Регистрација!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegistrationActivity.this, "Корисникот е веќе Регистриран!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



        TextView btn = findViewById(R.id.alreadyHaveAcc);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(RegistrationActivity.this, LogInActivity.class));
            }
        });
    }
}
package com.example.proektandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    EditText username,password;
    Button  btnlogin;
    TextView dontHaveAcc;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        username = (EditText)findViewById(R.id.inputLoginUsername);
        password = (EditText)findViewById(R.id.inputLoginPassword);
        btnlogin = (Button)findViewById(R.id.btnLogIn);
        dontHaveAcc = (TextView)findViewById(R.id.dontHaveAcc);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")){
                    Toast.makeText(LogInActivity.this, "Внеси Корисничко Име и Лозинка", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuser = DB.checkusername(user);
                    if (checkuser == false) {
                        Toast.makeText(LogInActivity.this, "Грешно Корисничко Име или Лозинка", Toast.LENGTH_SHORT).show();
                    } else {
                        if (user.equals("Admin")) {
                            if (pass.equals("Admin123")) {
                                Intent intent = new Intent(getApplicationContext(), AdministratorActivity.class);
                                startActivity(intent);
                            } else {
                                Intent intent1 = new Intent(getApplicationContext(), UserActivity.class);
                                startActivity(intent1);
                            }
                        } else {
                            Intent inten2 = new Intent(getApplicationContext(), UserActivity.class);
                            startActivity(inten2);
                        }
                    }
                }
            }
        });

        dontHaveAcc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });


        TextView btn = findViewById(R.id.dontHaveAcc);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LogInActivity.this, RegistrationActivity.class));
            }
        });



    }
}
package com.example.proektandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class VnesiPrasanja3Activity extends AppCompatActivity {
    EditText Prasanje3;
    EditText answer1, answer2, answer3, answer4;
    Button btnPrasanjaVneseni3;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vnesi_prasanja3);

        Prasanje3 = (EditText)findViewById(R.id.Prasanje3);
        answer1 = (EditText)findViewById(R.id.tretOdgovor1);
        answer2 = (EditText)findViewById(R.id.tretOdgovor2);
        answer3 = (EditText)findViewById(R.id.tretOdgovor3);
        answer4 = (EditText)findViewById(R.id.tretOdgovor4);
        btnPrasanjaVneseni3 = (Button) findViewById(R.id.btnPrasanjaVneseni3);
        DB = new DBHelper(this);

        btnPrasanjaVneseni3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Questions = Prasanje3.getText().toString();
                String ans1 = answer1.getText().toString();
                String ans2 = answer2.getText().toString();
                String ans3 = answer3.getText().toString();
                String ans4 = answer4.getText().toString();

                Boolean checkinsertdata = DB.insertData4(Questions, ans1, ans2, ans3, ans4);
                if (Questions.equals("") || ans1.equals("") || ans2.equals("") || ans3.equals("") || ans4.equals("")){
                    Toast.makeText(VnesiPrasanja3Activity.this, "Внесете Прашање и Одговори!", Toast.LENGTH_SHORT).show();
                }else{
                    if(checkinsertdata==true){
                        Toast.makeText(VnesiPrasanja3Activity.this, "Успешно Внесено Прашање и Одговори!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), AdministratorGlasanjeActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(VnesiPrasanja3Activity.this, "Неуспешно Внесување!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
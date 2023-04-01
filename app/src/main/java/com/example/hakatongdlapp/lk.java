package com.example.hakatongdlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class lk extends AppCompatActivity {
    private EditText person_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lk);
        String score;
        Intent intentReceived = getIntent();
        Bundle data = intentReceived.getExtras();
        if(data != null){
            score = data.getString("key");
        }else{
            score = "ERROR";
        }
        TextView score1 = (TextView) findViewById(R.id.scoreprint);
        score1.setText(score);
        person_name=findViewById(R.id.nameperson);

   }

    public void goBack(View v){
        Intent intention = new Intent(this,MainActivity.class);
        startActivity(intention);
        finish();
    }
    public void Savename(View view){
    String person_namestr=person_name.getText().toString();
        try {
            FileOutputStream file1=openFileOutput("user_name.txt", MODE_PRIVATE);
            file1.write(person_namestr.getBytes());
            file1.close();
            person_name.setText("");
            Toast.makeText(this,"Имя сохранено",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void Dounloadname(View view) {
        try {
            FileInputStream fileInput1 = openFileInput("person_name.txt");
            InputStreamReader reader_name = new InputStreamReader(fileInput1);
            BufferedReader reader_name2 = new BufferedReader(reader_name);
            String reader_name3=reader_name2.readLine();
            TextView person_name_set = (TextView) findViewById(R.id.personnameset);
            person_name_set.setText(reader_name3);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
package com.example.hakatongdlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class lk extends AppCompatActivity {

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
            score = "HUITA";
        }
        TextView score1 = (TextView) findViewById(R.id.scoreprint);
        score1.setText(score);
   }
    public void goBack(View v){
        Intent intention = new Intent(this,MainActivity.class);
        startActivity(intention);
        finish();
    }



}
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
        Bundle score2 = getIntent().getExtras();
        String score =  score2.getString("key");
        TextView score1 = (TextView) findViewById(R.id.scoreprint);
        score1.setText(score);
    }
    private void goHome(View v){
        Intent intention = new Intent(this,MainActivity.class);
        startActivity(intention);
    }



}
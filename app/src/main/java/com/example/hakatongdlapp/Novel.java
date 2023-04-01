package com.example.hakatongdlapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

public class Novel extends AppCompatActivity {

    TextView textNovella;
    AppCompatButton buttonRight;
    AppCompatButton buttonLeft;

    int position,i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textNovella     =   findViewById(R.id.text_view_novel);
        buttonLeft      =   findViewById(R.id.button_left);
        buttonRight     =   findViewById(R.id.button_right);



    }
}
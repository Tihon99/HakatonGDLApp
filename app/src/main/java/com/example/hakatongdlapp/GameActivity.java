package com.example.hakatongdlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GameActivity extends AppCompatActivity {

    /*ImageButton ImageButtonotvet1;
    int flag,combo_count,sum;
    int massive_otvetov[];
    private TextView Score;
    private TextView combo_count_view;
    @SuppressLint("MissingInflatedId")*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_touches);
        /*sum=0;
        combo_count=1;
        flag=1;
        massive_otvetov = new int[30];*/
    }


   /* public void klickotvet(View view) {
        Score=findViewById(R.id.score);
        combo_count_view=findViewById(R.id.combo_count);
        if(flag==1){
            combo_count++;
            sum+=combo_count;
            Score.setText(String.valueOf(sum));
            combo_count_view.setText(String.valueOf(combo_count));
        }
        else{
            combo_count=1;
            combo_count_view.setText(String.valueOf(combo_count));
            Toast.makeText(this,"Ответ не верный",Toast.LENGTH_SHORT).show();
        }
        //счётчик очков



    }*/
}
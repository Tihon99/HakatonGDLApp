package com.example.hakatongdlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    ImageButton ImageButtonotvet1;
    int flag,combo_count,sum;
    private TextView Score;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        sum=0;
        combo_count=1;
        flag=1;

    }



    public void klickotvet(View view) {

        if(flag==1){
            combo_count= combo_count*2;
            sum+=combo_count;
            Score=findViewById(R.id.score);
            Score.setText(String.valueOf(sum));
        }
        else{
            combo_count=1;
            Toast.makeText(this,"Ответ не верный",Toast.LENGTH_SHORT).show();
        }
    }
}
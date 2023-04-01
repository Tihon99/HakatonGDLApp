package com.example.hakatongdlapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startLK(View v){
        Intent intention = new Intent(this,lk.class);
        startActivity(intention);
    }
    public void startNovel(View v){
        Intent intention = new Intent(this,Novel.class);
        startActivity(intention);
    }
    public void sendNum(View v){
        String value="10";
        Intent i = new Intent(this, lk.class);
        i.putExtra("key",value);
        startActivity(i);
    }
}
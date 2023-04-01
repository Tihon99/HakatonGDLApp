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
        sendNum();
        Intent intention = new Intent(this,lk.class);
        startActivity(intention);
    }
    public void startNovel(View v){
        sendTxt();
        Intent intention = new Intent(this,Novel.class);
        startActivity(intention);
    }
    public void sendNum(){
        String value="10";
        Intent i = new Intent(this, lk.class);
        i.putExtra("key",value);
        startActivity(i);
    }
    public void sendTxt(){
        String value="novel1.txt";
        Intent i = new Intent(this, Novel.class);
        i.putExtra("tag",value);
        startActivity(i);
    }

}
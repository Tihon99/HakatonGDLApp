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
        sendNum();
        finish();
    }
    public void startNovel(View v){
        Intent intention = new Intent(this,Novel.class);
        startActivity(intention);
        sendTxt();
        finish();
    }
    public void sendNum(){
        Intent intent1 = new Intent (this, lk.class);
        Bundle data1 = new Bundle();
        data1.putString("key","restaurantUsername");
        intent1.putExtras(data1);
        startActivity(intent1);
    }
    public void sendTxt(){
        Intent intent1 = new Intent (this, Novel.class);
        Bundle data1 = new Bundle();
        data1.putString("tag","novel1.txt");
        intent1.putExtras(data1);
        startActivity(intent1);
    }

}
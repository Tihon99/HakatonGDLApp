package com.example.hakatongdlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListNovelActivity extends AppCompatActivity {

    Button button_teor1;
    Button button_teor2;
    Button button_teor3;

    String names_of_novels[] = {"novel1.txt", "novel2.txt", "novel3.txt"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_novel);

        button_teor1 = (Button) findViewById(R.id.button_teor1);
        button_teor2 = (Button) findViewById(R.id.button_teor2);
        button_teor3 = (Button) findViewById(R.id.button_teor3);

        onClickButtonTeor(button_teor1, 0);
        onClickButtonTeor(button_teor2, 1);
        onClickButtonTeor(button_teor3, 2);


    }
    public void onClickButtonTeor(View v, int i) {
        ((Button)v).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ListNovelActivity.this, Novel.class);
                Bundle data1 = new Bundle();
                data1.putString("tag", names_of_novels[i]);
                intent1.putExtras(data1);
                startActivity(intent1);
                finish();
            }
        });
    }
}
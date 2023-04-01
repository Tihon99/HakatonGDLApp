package com.example.hakatongdlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GameActivity extends AppCompatActivity {
    ImageButton ImageButtonotvet1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final float[] i = {100};
        ImageButtonotvet1 = (ImageButton)findViewById(R.id.imageButton12);
        ImageButtonotvet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Runnable task = () -> {
                    for (int k = 0; k < 100; k++) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ie) {
                            System.out.println();
                        }
                        ImageButtonotvet1.setTranslationX(i[0]);
                        i[0] += 2;
                    }

                };
            }
        });
    }
}
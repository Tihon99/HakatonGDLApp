package com.example.hakatongdlapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Novel extends AppCompatActivity {

    TextView textNovella;
    AppCompatButton buttonRight;
    AppCompatButton buttonLeft;

    String partNovel;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textNovella     =   findViewById(R.id.text_view_novel);
        buttonLeft      =   findViewById(R.id.button_left);
        buttonRight     =   findViewById(R.id.button_right);

        partNovel = getIntent().getStringExtra("tag");

        String lines[] = readFile(partNovel); //массив с текстом
        Log.d("Lines",lines[0]);
        textNovella.setText("sdsaidfhasoifi"); //вывод первого текста на экран

        buttonRight.setOnClickListener(v -> {
            Log.d("linesi", "" + i);

            if (i + 1 == lines.length) {
                Intent intent1 = new Intent(Novel.this, GameActivity.class);
                intent1.putExtra("tag", partNovel);
                startActivity(intent1);
                finish();
            }
            else
            if (i + 1 < lines.length) {
                i++;
                textNovella.setText(lines[i]);
                if (i + 2 == lines.length) {
                    buttonRight.setText("Вернуться на карту");
                    //buttonRight.setBackground(getResources().getDrawable(R.drawable.button_slyle_stoke_yellow));
                    i++;
                }
            }

        });


        buttonLeft.setOnClickListener(v -> {
            if (i < 0) {
                buttonRight.setText("вперёд");
                //buttonRight.setBackground(getResources().getDrawable(R.drawable.button_slyle_stoke_blue));
                i--;
                textNovella.setText(lines[i]);
            }
        });



    }
    private String[] readFile(String tag) {
        AssetManager assetManager = this.getAssets();
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(assetManager.open(tag));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> bufferArray = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line;
            while((line = br.readLine()) != null){
                bufferArray.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //String lines[] = readFile(quest.getTagButtonOne(partNovel.replaceAll("[^A-Za-z]",""))).split("\n");
        return bufferArray.toArray(new String[bufferArray.size()]);
    }
}
package com.example.jptv20_10_03_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        Button valgusfoorBtn = findViewById(R.id.button2);
        Switch switchMain = findViewById(R.id.switch1);
        Random rnd = new Random();
        valgusfoorBtn.setOnClickListener( b -> {
            Intent tabIntent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(tabIntent);
        });
        button.setOnClickListener(v -> {
            if(switchMain.isChecked()){
                textView.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                counter--;
                counter--;
            }else{
                textView.setBackgroundColor(Color.argb(255, 255,255,255));
            }
            counter++;
            textView.setText(String.valueOf(counter));
        });
    }

}
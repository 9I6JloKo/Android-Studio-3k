package com.example.jptv20_10_03_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btnGreen = findViewById(R.id.button3);
        Button btnRed = findViewById(R.id.button4);
        Button btnYellow = findViewById(R.id.button5);
        Button btnBack = findViewById(R.id.button6);
        View view = this.getWindow().getDecorView();
        TextView viewMain = findViewById(R.id.textView2);
        btnGreen.setOnClickListener(e -> {
            view.setBackgroundColor(Color.argb(255,0,255,0));
            viewMain.setText("GREEN");
        });
        btnRed.setOnClickListener(e -> {
            view.setBackgroundColor(Color.argb(255,255,0,0));
            viewMain.setText("RED");
        });

        btnYellow.setOnClickListener(e -> {
            view.setBackgroundColor(Color.argb(255,0,0,255));
            viewMain.setText("BLUE");
        });
        btnBack.setOnClickListener(e -> {
            Intent tabIntent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(tabIntent);
        });

    }
}
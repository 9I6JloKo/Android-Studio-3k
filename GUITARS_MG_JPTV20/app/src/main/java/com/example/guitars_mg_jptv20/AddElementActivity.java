package com.example.guitars_mg_jptv20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class AddElementActivity extends AppCompatActivity {
    TextView name;
    TextView year;
    TextView description;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_element);
        name = findViewById(R.id.nameTextAdd);
        year = findViewById(R.id.yearTextAdd);
        description = findViewById(R.id.descriptionTextAdd);
        Button BackToMain = findViewById(R.id.BackToMain);
        Button addElemButton = findViewById(R.id.addElemButton);
        BackToMain.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
                v.getContext().st;
            }
        });
        databaseHelper = new DatabaseHelper(getApplicationContext());
        db = databaseHelper.getReadableDatabase();
        db.execSQL("INSERT INTO "+ databaseHelper.TABLE +" (" + databaseHelper.COLUMN_NAME
                + ", " + databaseHelper.COLUMN_YEAR  + ", " + databaseHelper.COLUMN_DESCRIPTION + ") VALUES (" + name.getText() + ", " + year.getText() + ", " + description.getText() + ");");
    }
}
package com.example.guitars_mg_jptv20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddElementActivity extends AppCompatActivity {
    TextView name;
    TextView year;
    TextView description;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;

    TextView mainInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_element);
        mainInfo = findViewById(R.id.textView2);
        name = findViewById(R.id.nameTextUpdate);
        year = findViewById(R.id.yearTextUpdate);
        description = findViewById(R.id.descriptionTextUpdate);
        Button BackToMain = findViewById(R.id.BackToMain);
        Button addElemButton = findViewById(R.id.updateButton);
        BackToMain.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        addElemButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(name.getText().length() != 0 && year.getText().length() != 0 && description.getText().length() != 0){
                    databaseHelper = new DatabaseHelper(getApplicationContext());
                    db = databaseHelper.getReadableDatabase();
                    db.execSQL("INSERT INTO "+ databaseHelper.TABLE +" (" + databaseHelper.COLUMN_NAME
                            + ", " + databaseHelper.COLUMN_YEAR  + ", " + databaseHelper.COLUMN_DESCRIPTION + ") VALUES ('" + name.getText() + "', " + year.getText() + ", '" + description.getText() + "');");
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                }else{
                    mainInfo.setText("fields required!");
                }
            }
        });
    }
}
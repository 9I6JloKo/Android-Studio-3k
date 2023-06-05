package com.example.guitars_mg_jptv20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UpdateDeleteItemActivity extends AppCompatActivity {
    TextView name;
    TextView year;
    TextView description;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;

    TextView mainInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_item);
        mainInfo = findViewById(R.id.textView2);
        name = findViewById(R.id.nameTextUpdate);
        year = findViewById(R.id.yearTextUpdate);
        description = findViewById(R.id.descriptionTextUpdate);
        Button BackToMain = findViewById(R.id.BackToMain);
        Button updateButton = findViewById(R.id.updateButton);
        Button deleteButton = findViewById(R.id.deleteButton);

        databaseHelper = new DatabaseHelper(getApplicationContext());
        db = databaseHelper.getReadableDatabase();
        int id = Integer.parseInt(getIntent().getExtras().get("itemNumber").toString()) + 1;
        Cursor query = db.rawQuery("SELECT * FROM guitars", null);
        while(query.moveToNext()) {
            if(query.getInt(0) == id){
                String nameString = query.getString(1);
                String yearString = String.valueOf(query.getInt(2));
                String descriptionString = query.getString(3);
                name.setText(nameString);
                year.setText(yearString);
                description.setText(descriptionString);
                break;
            }
        }
//        name.setText(nameString);

        BackToMain.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        updateButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(name.getText().length() != 0 && year.getText().length() != 0 && description.getText().length() != 0){
                    db.execSQL("UPDATE "+ databaseHelper.TABLE +" SET " + databaseHelper.COLUMN_NAME + " = '" + name.getText() +"', " + databaseHelper.COLUMN_YEAR  + " = " + year.getText() + ", " + databaseHelper.COLUMN_DESCRIPTION + " = '" + description.getText() + "' WHERE _id = " + id) ;
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                }else{
                    mainInfo.setText("fields required!");
                }
            }
        });
        deleteButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                    db.execSQL("DELETE FROM " + databaseHelper.TABLE + " WHERE _id = " + id) ;
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
            }
        });
    }
}
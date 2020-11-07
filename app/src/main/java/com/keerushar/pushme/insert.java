package com.keerushar.pushme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class insert extends AppCompatActivity {

    LinearLayout container;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        databaseHelper=new DatabaseHelper(this);
        container=findViewById(R.id.container);

    }



}

package com.keerushar.pushme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class Calender_show extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    LinearLayout cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_show);

        setupBottomNavigationView();
        cal = findViewById(R.id.cal);
        databaseHelper = new DatabaseHelper(this);
        displayevent();

    }

    public void displayevent(){
        ArrayList<EventInfo> list=databaseHelper.geteventList();

        for(int i=0;i<list.size();i++){
            EventInfo info= list.get(i);
        }
        for ( final EventInfo info:list) {
            TextView textView= new TextView(this);
            textView.setText("username:" + info.eventname+ "\nlocation:" +info.location + "\ndate:" +info.date);
            cal.addView(textView);
        }
    }

    private void setupBottomNavigationView() {
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(Calender_show.this, this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

    }
    }


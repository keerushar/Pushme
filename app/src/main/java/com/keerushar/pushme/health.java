package com.keerushar.pushme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class health extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        setupBottomNavigationView();

    }
        private void setupBottomNavigationView() {
            BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
            BottomNavigationHelper.setupBottomNavigationView(bottomNavigationViewEx);
            BottomNavigationHelper.enableNavigation(health.this, this,bottomNavigationViewEx);
            Menu menu = bottomNavigationViewEx.getMenu();
            MenuItem menuItem = menu.getItem(1);
            menuItem.setChecked(true);

        }
}

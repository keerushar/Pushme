package com.keerushar.pushme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class workout_activity extends AppCompatActivity {

    TabLayout tab;
    ViewPager pager;
    PagerAdapter pagerAdapter;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_activity);

        setupBottomNavigationView();
        tab = (TabLayout) findViewById(R.id.tab);
        tab.addTab(tab.newTab().setText("Workout"));
        tab.addTab(tab.newTab().setText("Full-body"));
        tab.addTab(tab.newTab().setText("Abs"));
        tab.addTab(tab.newTab().setText("Arm"));
        tab.addTab(tab.newTab().setText("Leg"));

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new PagerAdapter(getApplicationContext(), getSupportFragmentManager(), tab.getTabCount());
        pager.setAdapter(pagerAdapter);
        pager.setOffscreenPageLimit(pagerAdapter.getCount() > 1 ? pagerAdapter.getCount() - 1 : 1);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }
    private void setupBottomNavigationView() {
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(workout_activity.this, this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

    }
}


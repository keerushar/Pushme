package com.keerushar.pushme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationHelper {


    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, final Activity callingActivity, BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.homepage:
                        Intent intent1 = new Intent(context, designActivity.class);//ACTIVITY_NUM = 0
                        context.startActivity(intent1);
                        break;

                    case R.id.health:
                        Intent intent2  = new Intent(context, health.class);//ACTIVITY_NUM = 1
                        context.startActivity(intent2);
                        break;

                    case R.id.calender:
                        Intent intent3 = new Intent(context, Calender_show.class);//ACTIVITY_NUM = 2
                        context.startActivity(intent3);
                        break;

                    case R.id.work:
                        Intent intent4 = new Intent(context, workout_activity.class);//ACTIVITY_NUM = 3
                        context.startActivity(intent4);
                        break;

                    case R.id.noti:
                        Intent intent5 = new Intent(context, notification_activity.class);//ACTIVITY_NUM = 4
                        context.startActivity(intent5);
                        break;
                }


                return false;
            }
        });
    }

}

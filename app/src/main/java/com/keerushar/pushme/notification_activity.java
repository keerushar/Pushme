package com.keerushar.pushme;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class notification_activity extends AppCompatActivity {

    LinearLayout main;
    DatabaseHelper databaseHelper;
    String Id ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_notification_activity);
        setupBottomNavigationView();
        main = findViewById(R.id.main);
        databaseHelper = new DatabaseHelper(this);
        displaynoti();






    }
        public void displaynoti(){
        ArrayList<NotificationInfo> list=databaseHelper.getnotificationList();

        main.removeAllViews();
        for(int i=0;i<list.size();i++){
            NotificationInfo info= list.get(i);
        }
        for ( final NotificationInfo info:list) {

            View view = LayoutInflater.from(this).inflate(R.layout.notification_menu,null);
            TextView notiname= view.findViewById(R.id.noti);
            TextView time= view.findViewById(R.id.time);

            notiname.setText(info.notiname);
            time.setText(info.time);
            main.addView(view);

            view.findViewById(R.id.popup).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPopupMenu(v);
                }
            });


        }
    }
    public void showPopupMenu(View anchor){
        PopupMenu popupMenu = new PopupMenu(this,anchor);
        getMenuInflater().inflate(R.menu.eventmenu,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.edit:
                        AlertDialog.Builder mbuilder = new AlertDialog.Builder(notification_activity.this);
                        View mview = getLayoutInflater().inflate(R.layout.notification_dialog,null);

                        break;
                    case R.id.delete:
                        showAlertDialog();
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    public void showAlertDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Are you want to sure");
        dialog.setMessage("Delete!!");
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                databaseHelper.deleteNotification(Integer.parseInt(Id));
                finish();
            }
        });
        dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }
    private void setupBottomNavigationView() {
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(notification_activity.this, this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

    }
}


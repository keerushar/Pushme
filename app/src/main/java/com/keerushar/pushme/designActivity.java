package com.keerushar.pushme;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class designActivity extends AppCompatActivity {
    ViewPager viewPager;
    private int dotcounts;
    LinearLayout sliderdots;
    private  ImageView[] dots;
    DatabaseHelper databaseHelper;
    SharedPreferences preferences;
    FloatingActionMenu floatingactionmenu;
    FloatingActionButton notes, event, notification;
    DatePickerDialog.OnDateSetListener  datesetlistener;
    TimePickerDialog.OnTimeSetListener  timeSetListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design);
        preferences = getSharedPreferences("userinfo", 0);

        databaseHelper = new DatabaseHelper(this);
        floatingactionmenu = (FloatingActionMenu) findViewById(R.id.fab_menu);
        notes = (FloatingActionButton) findViewById(R.id.fab1);
        event = (FloatingActionButton) findViewById(R.id.fab2);
        notification = (FloatingActionButton) findViewById(R.id.fab3);
        sliderdots = (LinearLayout) findViewById(R.id.sliderdots);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupBottomNavigationView();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
          viewPager.setAdapter(viewPagerAdapter);
          dotcounts = viewPagerAdapter.getCount();
          dots = new ImageView[dotcounts];

        for(int i =0; i< dotcounts; i++ ){
             dots[i] = new ImageView(this);
             dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext()
                                                              ,R.drawable.ic_dot_grey));
             LinearLayout.LayoutParams params =new LinearLayout.LayoutParams
                                               (LinearLayout.LayoutParams.WRAP_CONTENT,
                                               LinearLayout.LayoutParams.WRAP_CONTENT);
                                        params.setMargins(8,0,8,0);
                                        sliderdots.addView(dots[i],params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_dot_icon));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
                 public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for( int i = 0; i<dotcounts ;i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_dot_grey));
                    }

                      dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_dot_icon));
            }

            @Override
                 public void onPageScrollStateChanged(int state) {

            }
        });


           Timer timer = new Timer();
                timer.scheduleAtFixedRate(new MyTimerTask(),4000,2000);


        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder = new AlertDialog.Builder(designActivity.this);
                View mview = getLayoutInflater().inflate(R.layout.activity_editevent,null);
                final EditText event_name = (EditText) mview.findViewById(R.id.event_name);
                final EditText location = (EditText) mview.findViewById(R.id.location);
                final ImageButton addloc = (ImageButton) mview.findViewById(R.id.addloc);
                final TextView datepick = (TextView) mview.findViewById(R.id.datepick);
                Button cancel = (Button) mview.findViewById(R.id.cancel);
                Button ok = (Button) mview.findViewById(R.id.ok);

                mbuilder.setView(mview);
                final AlertDialog dialog = mbuilder.create();
                dialog.show();

           addloc.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                 Intent intent = new Intent(designActivity.this,MapsActivity.class);
                 startActivity(intent);
               }
           });

         ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String eventval = event_name.getText().toString();
                    String locationval = location.getText().toString();
                    String dateval = datepick.getText().toString();
                    if (!eventval.isEmpty() && !locationval.isEmpty() && !dateval.isEmpty()) {

                        ContentValues contentValues = new ContentValues();
                        contentValues.put("eventname",eventval);
                        contentValues.put("location",locationval);
                        contentValues.put("date",dateval);
                        databaseHelper.insertEvent(contentValues);

                        Toast.makeText(designActivity.this, "Event created", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }else{
                        Toast.makeText(designActivity.this, "fill all the data", Toast.LENGTH_SHORT).show();
                    }
                }
         });


                datepick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar cal= Calendar.getInstance();
                        int year = cal.get(Calendar.YEAR);
                        int month = cal.get(Calendar.MONTH);
                        int day = cal.get(Calendar.DAY_OF_MONTH);

                        DatePickerDialog dialog = new DatePickerDialog(
                                designActivity.this,
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                datesetlistener,
                                year,month,day);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();
                    }
                });

                datesetlistener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = month +"/" + dayOfMonth + "/" + year ;
                        datepick.setText(date);
                    }
                };


                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(designActivity.this, insert.class);
                startActivity(intent);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder = new AlertDialog.Builder(designActivity.this);
                View mview = getLayoutInflater().inflate(R.layout.notification_dialog,null);
                final EditText event_nam = (EditText) mview.findViewById(R.id.event_nam);
                final TextView timepick = (TextView) mview.findViewById(R.id.timepick);
                Button cancel = (Button) mview.findViewById(R.id.cancel);
                Button ok = (Button) mview.findViewById(R.id.ok);

                mbuilder.setView(mview);
                final AlertDialog dialog = mbuilder.create();
                dialog.show();

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String notival = event_nam.getText().toString();
                        String timeval = timepick.getText().toString();
                        if (!notival.isEmpty()  && !timeval.isEmpty()) {




                            ContentValues contentValues = new ContentValues();
                            contentValues.put("notiname",notival);
                            contentValues.put("time",timeval);


                                databaseHelper.insertNotification(contentValues);

                            Toast.makeText(designActivity.this, "Notification created", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }else{
                            Toast.makeText(designActivity.this, "fill all the data", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                timepick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar cal=  Calendar.getInstance();
                        int hour = cal.get(Calendar.HOUR);
                        int min = cal.get(Calendar.MINUTE);

                        TimePickerDialog timePickerDialog = new TimePickerDialog(designActivity.this,
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth ,timeSetListener , hour ,min,false);
                                 timePickerDialog.show();
                    }
                });


                timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String time = hourOfDay + ":" + minute;
                        timepick.setText(time);
                    }
                };




                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


            }
        });
    }


    public class MyTimerTask extends TimerTask {
       @Override
        public void run() {
            designActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0)
                    {
                        viewPager.setCurrentItem(1);
                      } else if (viewPager.getCurrentItem()== 1)
                    {
                        viewPager.setCurrentItem(2);
                    } else if (viewPager.getCurrentItem()== 2){
                        viewPager.setCurrentItem(3);
                    }else {
                        viewPager.setCurrentItem(0);
                    }


            }
            });
        }


    }

    private void setupBottomNavigationView() {
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(designActivity.this, this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

    }




}

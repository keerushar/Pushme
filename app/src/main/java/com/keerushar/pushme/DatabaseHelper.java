package com.keerushar.pushme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper
 {
    static String dbname = "user";
    static int version =1;


    String sqlCreateNOtificationTable = "CREATE TABLE  if not exists`notificationtable` (\n" +
            "\t`Id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`notiname`\tTEXT,\n" +
            "\t`time`\tTEXT\n" +
            ")";

    String sqlCreateEventTable = "CREATE TABLE if not exists`eventtable` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`eventname`\tTEXT,\n" +
            "\t`location`\tTEXT,\n" +
            "\t`date`\tTEXT\n" +
            ")";

    public DatabaseHelper(Context context) {
        super(context, dbname, null,version);

        getWritableDatabase().execSQL(sqlCreateEventTable);
        getWritableDatabase().execSQL(sqlCreateNOtificationTable);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int old, int newv) {

    }


     public void insertEvent(ContentValues contentValues) {
         getWritableDatabase().insert("eventtable", "", contentValues);
     }
    public void insertNotification(ContentValues contentValues){
        getWritableDatabase().insert("notificationtable","",contentValues);
    }



    public ArrayList<EventInfo> geteventList(){
        String sql= "select * from eventtable";
        Cursor c= getReadableDatabase().rawQuery(sql,null);

        ArrayList<EventInfo> list=new ArrayList<>();
        while (c.moveToNext()){
            EventInfo info = new EventInfo();
            info.id=c.getString(c.getColumnIndex("id"));
            info.eventname=c.getString(c.getColumnIndex("eventname"));
            info.location=c.getString(c.getColumnIndex("location"));
            info.date=c.getString(c.getColumnIndex("date"));
            list.add(info);
        }
        c.close();
        return list;
    }

    public ArrayList<NotificationInfo> getnotificationList(){
        String sql= "select * from notificationtable";
        Cursor c= getReadableDatabase().rawQuery(sql,null);

        ArrayList<NotificationInfo> list=new ArrayList<>();
        while (c.moveToNext()){
            NotificationInfo info = new NotificationInfo();
            info.Id=c.getString(c.getColumnIndex("Id"));
            info.notiname=c.getString(c.getColumnIndex("notiname"));
            info.time=c.getString(c.getColumnIndex("time"));
            list.add(info);
        }
        c.close();
        return list;
    }

    public NotificationInfo getnotificationInfo(String Id){
        String sql= "select * from notificationtable where Id=" + Id;
        Cursor c= getReadableDatabase().rawQuery(sql,null);
         NotificationInfo info = new NotificationInfo();
        while (c.moveToNext()){
            info.Id=c.getString(c.getColumnIndex("Id"));
            info.notiname=c.getString(c.getColumnIndex("notiname"));
            info.time=c.getString(c.getColumnIndex("time"));
        }
        c.close();

        return info;
    }


}

package com.example.administrator.myapplication.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/5/4.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DB_NAME="mydb_db";
    public static final int DB_VERSION=1;
    public static final String TB_NAME="contact";
    public static final String FIELD_CID="cid";
    public static final String FIELD_CNAME="cname";
    public static final String FIELD_CPHONE="cphone";
    public static final String SQL="CREATE TABLE"+TB_NAME+"("+
            FIELD_CID+"integer primary key autoincrement,"+FIELD_CNAME+"text,"+FIELD_CPHONE+"text"+")";
    private static DatabaseHelper myInstance;
    public DatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
    }
    public static synchronized DatabaseHelper getInstance(Context context){
        if(myInstance==null){
            myInstance=new DatabaseHelper(context.getApplicationContext());
        }
        return myInstance;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long add(Contact contact){
        SQLiteDatabase db=myInstance.getReadableDatabase();
        ContentValues values=new ContentValues();
        long flag=db.insert(TB_NAME,null,values);
        return flag;
    }
}

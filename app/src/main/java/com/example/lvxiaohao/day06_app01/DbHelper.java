package com.example.lvxiaohao.day06_app01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by LVXIAOHAO on 2018/12/30.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "my.db";
    public static final int VERSION = 1;

    public DbHelper(Context context) {

        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_SQL = "create table user(_id integer primary key autoincrement, account text,password text,name text,phone text)";
        db.execSQL(CREATE_SQL);
        Log.i("test", "create table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
}

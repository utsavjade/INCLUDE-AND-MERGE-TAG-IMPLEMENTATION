package com.example.utsav.includeandmergetag.ServiceDatabaseEntry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by utsav on 10/7/15.
 */
public class DBHelper extends SQLiteOpenHelper {
    private final String mQueryCreate = "create table " + Constants.TABLE_NAME + "(" + Constants.COL_ID
            + " int NOT NULL AUTO_INCREMENT,"+ Constants.COL_TIME + " int,primary key("+Constants.COL_ID+"));";

    public DBHelper(Context context, String name) {
        super(context, name, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(mQueryCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table " + Constants.TABLE_NAME + " if exists;");
        db.execSQL(mQueryCreate);
    }
}

package com.example.utsav.includeandmergetag.ServiceDatabaseEntry;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;

public class MyService extends Service {
    DBHelper mDBHelper;
    private SQLiteDatabase mDatabase;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mDBHelper=new DBHelper(this,Constants.DB_NAME);
        mDatabase=mDBHelper.getWritableDatabase();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mDatabase.execSQL("insert into "+Constants.TABLE_NAME+" values(1,"+System.currentTimeMillis()+");");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

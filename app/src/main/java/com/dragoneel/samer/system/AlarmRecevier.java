package com.dragoneel.samer.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmRecevier extends BroadcastReceiver {
    public AlarmRecevier() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Logger","shiit "+System.currentTimeMillis());
//        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent tryToGetLocation=new Intent(context,LastLoctionService.class);
        Intent tryToGetRealLocation=new Intent(context,CurrentLocationService.class);
        context.startService(tryToGetRealLocation);
        context.startService(tryToGetLocation);
//        Intent intentAlarm = new Intent(context, AlarmRecevier.class);
        //set the alarm for particular time
//        alarmManager.set(AlarmManager.RTC_WAKEUP,120000, PendingIntent.getBroadcast(context,1,  intentAlarm, PendingIntent.FLAG_NO_CREATE));
        //Toast.makeText(context,"alarm set ",Toast.LENGTH_SHORT).show();
    }
}

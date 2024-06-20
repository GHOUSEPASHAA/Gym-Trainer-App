package com.example.gymtrainer;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeTracker {
    private static final String PREF_NAME = "TimeSpentPref";
    private static final String KEY_PREFIX = "time_spent_";
    private static final String KEY_LAST_DATE = "last_date";

    private static TimeTracker instance;
    private SharedPreferences sharedPreferences;
    private String currentDate;
    private long startTimeMillis;

    private TimeTracker(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        currentDate = getCurrentDate();
        startTimeMillis = sharedPreferences.getLong(KEY_PREFIX + currentDate, 0);
    }

    public static synchronized TimeTracker getInstance(Context context) {
        if (instance == null) {
            instance = new TimeTracker(context.getApplicationContext());
        }
        return instance;
    }

    public void startTimer() {
        startTimeMillis = System.currentTimeMillis();
    }

    public void stopTimer() {
        long elapsedTimeMillis = System.currentTimeMillis() - startTimeMillis;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(KEY_PREFIX + currentDate, elapsedTimeMillis);
        editor.apply();
    }

    public long getTimeSpentToday() {
        return sharedPreferences.getLong(KEY_PREFIX + currentDate, 0);
    }

    private String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }
}

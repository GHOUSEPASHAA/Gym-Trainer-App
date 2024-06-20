package com.example.gymtrainer;

// AppUsageManager.java
import android.content.Context;
import android.content.SharedPreferences;

public class AppUsageManager {
    private static final String PREF_FILE_NAME = "AppUsagePrefs";
    private static final String KEY_DAILY_TIME_SPENT = "DailyTimeSpent";

    private SharedPreferences sharedPreferences;

    public AppUsageManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void recordTimeSpent(int timeSpentMillis) {
        // Get current total time spent
        int totalSpent = sharedPreferences.getInt(KEY_DAILY_TIME_SPENT, 0);

        // Add new time spent
        totalSpent += timeSpentMillis;

        // Store updated total time spent
        sharedPreferences.edit().putInt(KEY_DAILY_TIME_SPENT, totalSpent).apply();
    }

    public long getDailyTimeSpent() {
        // Retrieve total time spent
        return sharedPreferences.getInt(KEY_DAILY_TIME_SPENT, 0);
    }
}

package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextClock;

public class LegExercise2 extends AppCompatActivity {
    private TextClock textClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg_exercise2);
        textClock = findViewById(R.id.textClock);

        // Set the base time to midnight (00:00:00)
        textClock.setFormat24Hour("00:00:00");
        textClock.setFormat12Hour(null);
    }
}
package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EyePain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_pain);
        Button beyep = findViewById(R.id.beyep);
        Button beyep2 = findViewById(R.id.beyep2);
        beyep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(EyePain.this, EyeExercise1.class);
                startActivity(intent);
            }
        });
        beyep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(EyePain.this, EyeExercise2.class);
                startActivity(intent);
            }
        });

    }
}
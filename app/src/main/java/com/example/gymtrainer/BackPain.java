package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BackPain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_pain);

        Button bbackp1 = findViewById(R.id.bbackp1);
        Button bbackp2 = findViewById(R.id.bbackp2);

        bbackp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(BackPain.this, BackExercise1.class);
                startActivity(intent);
            }
        });
        bbackp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(BackPain.this, BackExercise2.class);
                startActivity(intent);
            }
        });
    }
}
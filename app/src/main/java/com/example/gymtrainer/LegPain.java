package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LegPain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg_pain);

        Button blegp1 = findViewById(R.id.blegp1);
        Button blegp2 = findViewById(R.id.blegp2);

        blegp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(LegPain.this, LegExercise1.class);
                startActivity(intent);
            }
        });
        blegp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(LegPain.this, LegExercise2.class);
                startActivity(intent);
            }
        });

    }
}
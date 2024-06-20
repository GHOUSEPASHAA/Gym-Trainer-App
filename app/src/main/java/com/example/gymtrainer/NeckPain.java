package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NeckPain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neck_pain);


        Button bneck1 = findViewById(R.id.bneck1);
        Button bneck2 = findViewById(R.id.bneck2);

        bneck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(NeckPain.this, NeckExercise1.class);
                startActivity(intent);
            }
        });
        bneck2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(NeckPain.this, NeckExercise2.class);
                startActivity(intent);
            }
        });
    }

}
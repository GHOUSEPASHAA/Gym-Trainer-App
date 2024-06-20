package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChestPaining extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_paining);


        Button bchestp1 = findViewById(R.id.bchestp1);
        Button bchestp2 = findViewById(R.id.bchestp2);
        bchestp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(ChestPaining.this, ChestPain1.class);
                startActivity(intent);
            }
        });
        bchestp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(ChestPaining.this, ChestPain2.class);
                startActivity(intent);
            }
        });
    }
}
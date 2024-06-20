package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HandPAin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_pain);

        Button bhandp1 = findViewById(R.id.bhandp1);
        Button bhandp2 = findViewById(R.id.bhandp2);

       bhandp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(HandPAin.this,Handexercise1.class);
                startActivity(intent);
            }
        });
       bhandp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(HandPAin.this, Handexercise2.class);
                startActivity(intent);
            }
        });

    }
}
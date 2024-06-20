package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PainsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pains);
        ImageView ineck = findViewById(R.id.ineck);
        ImageView ieye = findViewById(R.id.ieye);
        ImageView iback = findViewById(R.id.iback);
        ImageView ileg = findViewById(R.id.ileg);
        ImageView ihand = findViewById(R.id.ihand);
        ImageView ichest = findViewById(R.id.ichest);
        ineck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(PainsActivity.this, NeckPain.class);
                startActivity(intent);
            }
        });
        ieye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(PainsActivity.this, EyePain.class);
                startActivity(intent);
            }
        });
        iback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(PainsActivity.this, BackPain.class);
                startActivity(intent);
            }
        });
        ileg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(PainsActivity.this, LegPain.class);
                startActivity(intent);
            }
        });
       ihand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(PainsActivity.this, HandPAin.class);
                startActivity(intent);
            }
        });

        ichest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(PainsActivity.this, ChestPaining.class);
                startActivity(intent);
            }
        });
    }
}
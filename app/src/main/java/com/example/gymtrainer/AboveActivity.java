package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AboveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_above);
        ImageView abs = findViewById(R.id.absimage);
        ImageView biceps = findViewById(R.id.bicepsimage);
        ImageView legs = findViewById(R.id.legs);
        ImageView shoulder = findViewById(R.id.shoulder);
        ImageView chest = findViewById(R.id.chest);
        ImageView triceps = findViewById(R.id.triceps);

        abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to execute when the image is clicked
                //Toast.makeText(this, "abs clicked!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AboveActivity.this, AbsActivity.class);
                startActivity(intent);
            }
        });

        biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to execute when the image is clicked
                //Toast.makeText(this, "abs clicked!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AboveActivity.this, BicepsActivity.class);
                startActivity(intent);
            }
        });
       legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to execute when the image is clicked
                //Toast.makeText(this, "abs clicked!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AboveActivity.this, Legs.class);
                startActivity(intent);
            }
        });
        shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to execute when the image is clicked
                //Toast.makeText(this, "abs clicked!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AboveActivity.this, Shoulders.class);
                startActivity(intent);
            }
        });
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to execute when the image is clicked
                //Toast.makeText(this, "abs clicked!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AboveActivity.this, Chestworkout.class);
                startActivity(intent);
            }
        });
        triceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to execute when the image is clicked
                //Toast.makeText(this, "abs clicked!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AboveActivity.this, Tricep.class);
                startActivity(intent);
            }
        });
    }

}
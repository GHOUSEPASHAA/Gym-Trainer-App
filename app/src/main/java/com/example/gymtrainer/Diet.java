package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Diet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        Button bchild = findViewById(R.id.bchild);
        Button bteenf = findViewById(R.id.bteenf);
        Button bteenm = findViewById(R.id.bteenm);
        Button badultf = findViewById(R.id.badultf);
        Button badultm = findViewById(R.id.badultm);
        Button bolda = findViewById(R.id.bolda);
        bchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(Diet.this, ChildrenDiet.class);
                startActivity(intent);
            }
        });
        bteenf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(Diet.this, TeenFemale.class);
                startActivity(intent);
            }
        });
        bteenm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(Diet.this, TeenMale.class);
                startActivity(intent);
            }
        });
        badultf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(Diet.this, AdultFemale.class);
                startActivity(intent);
            }
        });
        badultm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(Diet.this, AdultMale.class);
                startActivity(intent);
            }
        });
        bolda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the other activity
                Intent intent = new Intent(Diet.this, OldAge.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Calorie extends AppCompatActivity {

    private EditText foodNameEditText, quantityEditText;
    private Button detectButton;
    private TextView resultTextView;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);

        foodNameEditText = findViewById(R.id.food_name_edittext);
        quantityEditText = findViewById(R.id.quantity_edittext);
        detectButton = findViewById(R.id.detect_button);
        resultTextView = findViewById(R.id.result_textview);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("foods");

        detectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String foodName = foodNameEditText.getText().toString().trim();
                final int quantity = Integer.parseInt(quantityEditText.getText().toString().trim());
                databaseReference.child(foodName).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists() && dataSnapshot.child("calories").getValue() != null) {
                            long caloriesPer100g = dataSnapshot.child("calories").getValue(Long.class);
                            double caloriesPerGram = caloriesPer100g / 100.0;
                            double totalCalories = caloriesPerGram * quantity;
                            resultTextView.setText("Total Calories for " + quantity + " grams of " + foodName + ": " + totalCalories);
                        } else {
                            resultTextView.setText("Food not found or calorie information is missing");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle database error
                    }
                });
            }
        });
    }
}

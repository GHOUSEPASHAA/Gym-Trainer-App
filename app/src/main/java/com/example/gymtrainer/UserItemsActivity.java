package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gymtrainer.models.UserItem;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserItemsActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private LinearLayout userItemsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_items);

        // Initialize Firebase
        FirebaseApp.initializeApp(this);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("user_items");

        userItemsContainer = findViewById(R.id.userItemsContainer);

        // Read data from Firebase
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userItemsContainer.removeAllViews(); // Clear existing views
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    UserItem userItem = snapshot.getValue(UserItem.class);
                    if (userItem != null) {
                        createUserItemView(userItem, snapshot.getKey());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UserItemsActivity.this, "Failed to load items.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createUserItemView(UserItem userItem, String itemId) {
        // Create a view for the user item
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, 0, 0, 16);

        LinearLayout itemLayout = new LinearLayout(this);
        itemLayout.setLayoutParams(layoutParams);
        itemLayout.setOrientation(LinearLayout.HORIZONTAL);
        itemLayout.setGravity(Gravity.CENTER_VERTICAL);

        TextView itemNameTextView = new TextView(this);
        itemNameTextView.setText(userItem.getItemName());
        itemNameTextView.setLayoutParams(new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));

        TextView userNameTextView = new TextView(this);
        userNameTextView.setText(userItem.getUsername());
        userNameTextView.setLayoutParams(new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));

        Button deleteButton = new Button(this);
        deleteButton.setText("Delete");
        deleteButton.setOnClickListener(view -> {
            // Remove item from database
            databaseReference.child(itemId).removeValue();
        });

        itemLayout.addView(itemNameTextView);
        itemLayout.addView(userNameTextView);
        itemLayout.addView(deleteButton);

        userItemsContainer.addView(itemLayout);
    }
}

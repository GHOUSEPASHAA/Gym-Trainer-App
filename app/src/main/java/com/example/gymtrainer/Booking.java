package com.example.gymtrainer;

import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymtrainer.adapter.AbsAdapter;
import com.example.gymtrainer.adapter.BookingAdapter;
import com.example.gymtrainer.models.BookingModel;
import com.example.gymtrainer.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

import com.example.gymtrainer.models.UserItem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Booking extends AppCompatActivity {



    private RecyclerView recyclerView;
    private BookingAdapter adapter;
    private List<BookingModel> items;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        recyclerView = findViewById(R.id.srecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        items = new ArrayList<>();
        // Add sample items
        items.add(new BookingModel("Greensun whey 500gm", "4500rs", R.drawable.greensunwhey));
        items.add(new BookingModel("carnivor steroids \n 500gms", "16000rs", R.drawable.carnivorsteroid));
        items.add(new BookingModel("creatine Monohydrate \n 500gms", "12000", R.drawable.creatine));
        items.add(new BookingModel("creatine Monohydrate \n 500gms", "12000", R.drawable.creatine));
        items.add(new BookingModel("Reflex Whey \n 500gms", "36000", R.drawable.reflexwhey));

        adapter = new BookingAdapter(items, this);
        recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new BookingAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BookingModel item) {
                // Get current user's Google username
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser != null) {
                    String username = currentUser.getDisplayName();

                    // Get item details
                    String itemName = item.getName();
                    String itemPrice = item.getPrice();

                    // Write the data to Firebase Realtime Database
                    writeUserDataToDatabase(username, itemName, itemPrice);

                    // Show a toast message to indicate that data has been saved
                    Toast.makeText(Booking.this, "Data saved to Firebase", Toast.LENGTH_SHORT).show();
                } else {
                    // User is not signed in
                    Toast.makeText(Booking.this, "User not signed in", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void writeUserDataToDatabase(String username, String itemName, String itemPrice) {
        // Push a new node to the database under 'user_items' node
        mDatabase.child("user_items").push().setValue(new UserItem(username, itemName, itemPrice));
    }
}

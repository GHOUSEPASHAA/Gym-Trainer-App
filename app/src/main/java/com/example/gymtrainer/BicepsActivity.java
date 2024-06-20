package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymtrainer.adapter.AbsAdapter;
import com.example.gymtrainer.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class BicepsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AbsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps);

        recyclerView = findViewById(R.id.recyclerbiceps);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Sample data
        List<ItemModel> data = new ArrayList<>();
        data.add(new ItemModel("Bicep Curl", R.drawable.bicepcurl));
        data.add(new ItemModel("Dumbell Bicep curl", R.drawable.dbicepcurl));
        data.add(new ItemModel("Dumbbell Reverse bicep curl", R.drawable.dumbellreversepic));
        data.add(new ItemModel("Dumbell seated Alternate Bicep curl", R.drawable.dumbellseatedpic));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));

        adapter = new AbsAdapter(this, data);
        recyclerView.setAdapter(adapter);

    }
}
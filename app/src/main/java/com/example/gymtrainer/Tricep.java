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

public class Tricep extends AppCompatActivity {

    RecyclerView recyclerView;
    AbsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tricep);

        recyclerView = findViewById(R.id.recyclertriceps);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Sample data
        List<ItemModel> data = new ArrayList<>();
        data.add(new ItemModel("Concentration  Curl", R.drawable.tricep1pic));
        data.add(new ItemModel("Cross body hammer curl", R.drawable.tricep2pic));
        data.add(new ItemModel("Inner tricep curl", R.drawable.tricep3pic));
        data.add(new ItemModel("Preacher Curl", R.drawable.tricep4pic));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));

        adapter = new AbsAdapter(this, data);
        recyclerView.setAdapter(adapter);

    }
}
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

public class Legs extends AppCompatActivity {

    RecyclerView recyclerView;
    AbsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);

        recyclerView = findViewById(R.id.recyclerlegs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Sample data
        List<ItemModel> data = new ArrayList<>();
        data.add(new ItemModel("cross squats", R.drawable.crosssquat));
        data.add(new ItemModel("prisoner squats", R.drawable.prisonersqauts));
        data.add(new ItemModel("Jump squats", R.drawable.jumpsquatspic));
        data.add(new ItemModel("Wall sit", R.drawable.wallsitpic));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));

        adapter = new AbsAdapter(this, data);
        recyclerView.setAdapter(adapter);

    }
}
package com.example.gymtrainer;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymtrainer.adapter.AbsAdapter;
import com.example.gymtrainer.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class Chestworkout extends AppCompatActivity {

    RecyclerView recyclerView;
    AbsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chestworkout);

        recyclerView = findViewById(R.id.Recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data
        List<ItemModel> data = new ArrayList<>();
        data.add(new ItemModel("Kneeline pushup", R.drawable.kneelinepushup));
        data.add(new ItemModel("diamond pushups", R.drawable.diamondpushup));
        data.add(new ItemModel("pushups", R.drawable.pushups));
        data.add(new ItemModel("reverse kneeling pushups", R.drawable.reverseknelling));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));

        adapter = new AbsAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }
}

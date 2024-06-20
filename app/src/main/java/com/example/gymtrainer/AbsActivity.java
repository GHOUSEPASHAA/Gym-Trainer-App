package com.example.gymtrainer;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymtrainer.adapter.AbsAdapter;
import com.example.gymtrainer.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class AbsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AbsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs);

        recyclerView = findViewById(R.id.Recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data
        List<ItemModel> data = new ArrayList<>();
        data.add(new ItemModel("Crunches", R.drawable.crunches));
        data.add(new ItemModel("Heel Touches", R.drawable.helltouchepng));
        data.add(new ItemModel("cross crunches", R.drawable.crosscrunchespng));
        data.add(new ItemModel("Knee touches", R.drawable.kneetouchespic));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));
        data.add(new ItemModel("Item 2", R.drawable.crunches));

        adapter = new AbsAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }
}

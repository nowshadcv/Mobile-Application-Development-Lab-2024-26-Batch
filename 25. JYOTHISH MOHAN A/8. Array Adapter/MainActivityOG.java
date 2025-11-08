package com.example.arrayadaptor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] fruits = {"apple", "banana", "dates", "orange"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter<>(this, R.layout.activity_listview, R.id.textview, fruits));

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Class<?>[] activities = {apple.class, banana.class, dates.class, orange.class};
            startActivity(new Intent(MainActivity.this, activities[position]));
        });
    }
}

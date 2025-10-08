package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class  list_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
    }

    public void setAdapter(ArrayAdapter<String> arrayAdapter) {
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listView) {
    }
}
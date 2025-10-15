package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner1);  // Create an ArrayAdapter using the string array (R.array.numbers) and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);  // Context ,Array resource defined in res/values/arrays.xml ,Built-in spinner item layout
        // Set the layout for the dropdown menu
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Attach the adapter to the Spinner
        spinner.setAdapter(adapter);
        // Set this activity to listen to spinner selections
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Get the selected item text
        String text = parent.getItemAtPosition(position).toString();
        // Show the selected item in a toast message
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }
    // Called when no item is selected
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do nothing here for now
    }
}
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
        super.onCreate(savedInstanceState);  // Start the activity with basic setup
        setContentView(R.layout.activity_main); // Show the layout on the screen

        Spinner spinner = findViewById(R.id.spinner1);  // Find the dropdown menu (spinner) in the layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        // Create a list of items for the spinner from resources

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  // Set how the dropdown list looks
        spinner.setAdapter(adapter);  // Connect the list to the spinner so it shows the items

        spinner.setOnItemSelectedListener(this);  // Set a listener to handle selection events on spinner items
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

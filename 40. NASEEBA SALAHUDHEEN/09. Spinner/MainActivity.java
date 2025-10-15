package com.example.spinner;  // Defines the package name of the app

import androidx.appcompat.app.AppCompatActivity;  // Import for using AppCompatActivity class

import android.os.Bundle;  // Import for Bundle class to pass data between activities
import android.view.View;  // Import for View class representing UI elements
import android.widget.AdapterView;  // Import for AdapterView (parent class of Spinner)
import android.widget.ArrayAdapter;  // Import for ArrayAdapter to bind data to Spinner
import android.widget.Spinner;  // Import for Spinner UI component
import android.widget.Toast;  // Import for Toast to show short messages

// Main activity class that extends AppCompatActivity and implements Spinner item selection listener
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  // Call superclass method to handle setup
        setContentView(R.layout.activity_main);  // Set the layout file for this activity

        Spinner spinner = findViewById(R.id.spinner1);  // Find the Spinner view by its ID

        // Create an ArrayAdapter using string array resource (R.array.numbers) and default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  // Specify dropdown layout style

        spinner.setAdapter(adapter);  // Attach the adapter to the spinner to populate items

        spinner.setOnItemSelectedListener(this);  // Set this activity as the listener for item selection events
    }

    // Callback method invoked when an item in the spinner is selected
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();  // Get the selected item as a string
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();  // Show a short Toast message displaying the selected item
    }

    // Callback method invoked when no item is selected; required by interface but left empty
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // No action needed here
    }
}

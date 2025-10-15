package com.example.spinner;  // Defines the package name for the app

import android.os.Bundle;  // Imports Bundle class to handle passing data between Android components
import android.view.View;  // Imports View class for UI components
import android.widget.AdapterView;  // Imports AdapterView for handling item selections in views like Spinner
import android.widget.ArrayAdapter;  // Imports ArrayAdapter to provide data to views like Spinner
import android.widget.Spinner;  // Imports Spinner widget class
import android.widget.Toast;  // Imports Toast class to show brief messages on the screen

import androidx.activity.EdgeToEdge;  // Imports EdgeToEdge helper class for enabling edge-to-edge display
import androidx.appcompat.app.AppCompatActivity;  // Imports AppCompatActivity for backward-compatible activities
import androidx.core.graphics.Insets;  // Imports Insets class to get window inset dimensions
import androidx.core.view.ViewCompat;  // Imports ViewCompat for compatibility helper methods for views
import androidx.core.view.WindowInsetsCompat;  // Imports WindowInsetsCompat for handling window insets

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    // MainActivity class which extends AppCompatActivity and implements OnItemSelectedListener for spinner events

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Called when the activity is first created
        super.onCreate(savedInstanceState);  // Call parent class onCreate to perform default setup
        EdgeToEdge.enable(this);  // Enable edge-to-edge display for this activity
        setContentView(R.layout.activity_main);  // Set the layout resource file for this activity
        Spinner spinner=(Spinner) findViewById(R.id.spinner1);  // Find the Spinner view by its ID from layout
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(
                this, R.array.numbers, android.R.layout.simple_spinner_item);
        // Create an ArrayAdapter using a string array resource and a default spinner item layout

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Set the layout resource to create the drop-down views for the spinner

        spinner.setAdapter(adapter);  // Attach the adapter to the spinner
        spinner.setOnItemSelectedListener(this);  // Set this activity as the listener for spinner item selection events

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Set a listener to handle window insets (like system bars) on the root view with ID 'main'
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // Get the insets related to system bars (status, navigation bars)
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            // Apply the system bar insets as padding to the view to avoid UI overlapping with system bars
            return insets;  // Return the insets without consuming them
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Called when an item in the spinner is selected
        String text=parent.getItemAtPosition(position).toString();  // Get the selected item text
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        // Show a toast message displaying the selected item text
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Called when no item is selected in the spinner - empty implementation here
    }
}
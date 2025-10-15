package com.example.spinnercomponent;
// Declares the package name where this class resides.

import androidx.appcompat.app.AppCompatActivity;
// Imports AppCompatActivity class for backward-compatible Android activity features.

import android.os.Bundle;
// Imports Bundle class used to pass data between activities and save state.

import android.view.View;
// Imports View class for UI components interaction.

import android.widget.AdapterView;
// Imports AdapterView class to handle item selection events on adapter-based views.

import android.widget.ArrayAdapter;
// Imports ArrayAdapter to bind arrays or resources to views like Spinner.

import android.widget.Spinner;
// Imports Spinner widget class.

import android.widget.Toast;
// Imports Toast class to display brief messages to the user.

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
// Declares MainActivity class extending AppCompatActivity and implements OnItemSelectedListener interface to handle spinner selections.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // onCreate method is called when the activity is first created. Bundle contains saved state if any.

        super.onCreate(savedInstanceState);
        // Calls the parent class's onCreate to perform essential setup.

        setContentView(R.layout.activity_main);
        // Sets the UI layout of this activity to activity_main.xml.

        Spinner spinner = findViewById(R.id.spinner1);
        // Finds the Spinner widget from the layout by its ID (spinner1).

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        // Creates an ArrayAdapter using string-array resource 'numbers' and a simple spinner item layout.

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Sets the layout resource for dropdown menu items.

        spinner.setAdapter(adapter);
        // Attaches the adapter to the spinner to populate its options.

        spinner.setOnItemSelectedListener(this);
        // Registers this activity as the listener for item selection events on the spinner.
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Called when an item is selected from the spinner.

        String text = parent.getItemAtPosition(position).toString();
        // Retrieves the selected item’s text from the spinner at the clicked position.

        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        // Displays a short Toast message showing the selected item.
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Called when no item is selected. Required by the interface but not used here.

    }
}

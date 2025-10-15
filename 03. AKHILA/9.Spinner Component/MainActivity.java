package com.example.spinnercomponent;  // 1. Specifies the package for the app

import androidx.appcompat.app.AppCompatActivity;  // 2. Imports the AppCompatActivity class for compatibility

import android.os.Bundle;  // 3. Imports the Bundle class for managing activity state

import android.view.View;  // 4. Imports the View class to handle UI components

import android.widget.AdapterView;  // 5. Imports AdapterView to handle interactions with the Spinner

import android.widget.ArrayAdapter;  // 6. Imports ArrayAdapter to set an array of items in the Spinner

import android.widget.Spinner;  // 7. Imports Spinner class to use a dropdown list of items

import android.widget.Toast;  // 8. Imports the Toast class to display temporary messages

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {  // 9. Defines MainActivity class, which extends AppCompatActivity. Implements OnItemSelectedListener interface for Spinner selection events.

    @Override  // 10. Marks the method as overriding a superclass method
    protected void onCreate(Bundle savedInstanceState) {  // 11. onCreate method that initializes the activity when it's created
        super.onCreate(savedInstanceState);  // 12. Calls the parent class's onCreate method to set up the activity
        setContentView(R.layout.activity_main);  // 13. Sets the layout for the activity to activity_main.xml

        // 14. Finds the Spinner view by its ID (spinner1) from the layout
        Spinner spinner = findViewById(R.id.spinner1);

        // 15. Creates an ArrayAdapter using a resource array (numbers) and a simple spinner item layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);

        // 16. Sets the layout for the dropdown menu when the Spinner is clicked
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 17. Sets the adapter to the Spinner to provide the data source for the list
        spinner.setAdapter(adapter);

        // 18. Sets the OnItemSelectedListener to handle selection events in the Spinner
        spinner.setOnItemSelectedListener(this);
    }  // 19. End of onCreate method

    @Override  // 20. Marks this method as overriding a superclass method
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {  // 21. This method is called when an item is selected in the Spinner
        // 22. Retrieves the selected item from the Spinner
        String text = parent.getItemAtPosition(position).toString();

        // 23. Shows a Toast message with the selected item's text
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override  // 24. Marks this method as overriding a superclass method
    public void onNothingSelected(AdapterView<?> parent) {  // 25. This method is called when no item is selected
        // 26. Optional: Handle the case when nothing is selected (you can leave it empty)
    }  // 27. End of onNothingSelected method
}

package com.example.spinnercomponent;         // Package name for the application

import androidx.appcompat.app.AppCompatActivity; // Import AppCompatActivity class
import android.os.Bundle;                       // Import Bundle for activity state
import android.view.View;                       // Import View class
import android.widget.AdapterView;              // Import AdapterView listener interface
import android.widget.ArrayAdapter;             // Import ArrayAdapter for spinner data
import android.widget.Spinner;                  // Import Spinner UI component
import android.widget.Toast;                    // Import Toast for displaying messages

// Main activity class, implements OnItemSelectedListener to handle spinner item selection
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {   // Called when activity starts
        super.onCreate(savedInstanceState);                // Call parent class implementation
        setContentView(R.layout.activity_main);            // Set the UI layout for this activity

        Spinner spinner = findViewById(R.id.spinner1);     // Find spinner from XML by ID

        // Create an ArrayAdapter using values from strings.xml (R.array.numbers)
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this,                             // Context
                        R.array.numbers,                  // String array resource
                        android.R.layout.simple_spinner_item); // Layout for each item

        adapter.setDropDownViewResource(                   // Set layout for dropdown items
                android.R.layout.simple_spinner_item);     // (same layout used)

        spinner.setAdapter(adapter);                       // Attach adapter to spinner

        spinner.setOnItemSelectedListener(this);           // Set listener to handle selection
    }

    // Called when an item in the spinner is selected
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString(); // Get selected item text
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show(); // Show as Toast
    }

    // Called when no item is selected (required method, even if empty)
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

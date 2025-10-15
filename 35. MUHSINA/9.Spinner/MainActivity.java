package com.example.spinner; // Defines the package this class belongs to

import androidx.appcompat.app.AppCompatActivity; // Imports base class for activities using the AppCompat support library
import android.os.Bundle; // Import for Bundle class, used to pass data between activity states
import android.view.View; // Used to handle UI views
import android.widget.AdapterView; // Interface for item selection callbacks on AdapterViews like Spinners
import android.widget.ArrayAdapter; // Used to bind an array to the Spinner
import android.widget.Spinner; // UI element that displays a dropdown list
import android.widget.Toast; // Provides simple popup messages (toasts)

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    // MainActivity inherits from AppCompatActivity and implements OnItemSelectedListener for Spinner item selection

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Calls the superclass's onCreate method
        setContentView(R.layout.activity_main); // Sets the layout for this activity from XML file activity_main.xml

        Spinner spinner = findViewById(R.id.spinner1);
        // Finds the Spinner view by its ID defined in activity_main.xml

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, // Context: current Activity
                R.array.numbers, // Array resource from strings.xml (array of numbers)
                android.R.layout.simple_spinner_item // Layout for each item in the Spinner
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Sets the layout resource for how items appear when the dropdown is shown

        spinner.setAdapter(adapter);
        // Sets the adapter on the Spinner to populate it with data

        spinner.setOnItemSelectedListener(this);
        // Registers the activity to listen for item selection events
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Called when an item in the Spinner is selected

        String text = parent.getItemAtPosition(position).toString();
        // Gets the selected item's text as a String

        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        // Shows a toast message displaying the selected item
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Called when no item is selected in the Spinner (rarely used in most apps)
        // You can leave this empty or provide a default behavior
    }
}

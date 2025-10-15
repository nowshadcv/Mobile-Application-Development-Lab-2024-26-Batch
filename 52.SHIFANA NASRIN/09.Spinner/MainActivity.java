package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

// MainActivity implements OnItemSelectedListener to handle Spinner selection events
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set layout from activity_main.xml

        Spinner spinner = findViewById(R.id.spinner1); // Get Spinner view by ID

        // Create an ArrayAdapter using string array and default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,                        // Context
                R.array.number,              // String array resource
                android.R.layout.simple_spinner_item // Layout for each item
        );

        // Set layout for dropdown list
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);               // Set adapter to spinner
        spinner.setOnItemSelectedListener(this);   // Set listener for item selection
    }

    // Called when an item is selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString(); // Get selected item text
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show(); // Show a toast
    }

    // Called when nothing is selected (required method for interface)
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // You can leave this empty if not needed
    }
}

package com.example.spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

// MainActivity class implements AdapterView.OnItemSelectedListener to handle spinner item selection events
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity from activity_main.xml
        setContentView(R.layout.activity_main);

        // Get reference to the Spinner view by its ID
        Spinner spinner = findViewById(R.id.spinner1);

        // Create an ArrayAdapter using the string array resource (R.array.numbers) and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.numbers,
                android.R.layout.simple_spinner_item
        );

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Set this activity as the listener for item selection events on the spinner
        spinner.setOnItemSelectedListener(this);
    }

    // Called when an item is selected in the spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Get the selected item text from the adapter at the selected position
        String text = parent.getItemAtPosition(position).toString();

        // Show a toast message displaying the selected item
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    // Called when no item is selected in the spinner (rare case)
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // No action needed here
    }
}

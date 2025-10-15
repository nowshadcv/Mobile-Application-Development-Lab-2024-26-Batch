package com.example.spinner;

// Import necessary Android classes
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// MainActivity class implements AdapterView.OnItemSelectedListener
// to handle spinner item selection events
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_main);

        // Find the Spinner widget by its ID in the layout
        Spinner spinner = findViewById(R.id.spinner1);

        // Create an ArrayAdapter using the string array resource (R.array.numbers)
        // and a default spinner layout (simple_spinner_item)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.numbers,
                android.R.layout.simple_spinner_item
        );

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Set this activity as the listener for when an item is selected
        spinner.setOnItemSelectedListener(this);
    }

    // This method is called when an item is selected in the spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Get the selected item text from the adapter
        String text = parent.getItemAtPosition(position).toString();

        // Show a Toast message displaying the selected item
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    // This method is called when no item is selected in the spinner
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // No action needed here
    }
}

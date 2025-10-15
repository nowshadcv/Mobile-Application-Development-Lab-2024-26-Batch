package com.example.spinnercomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.spinnercomponent.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout file for this activity
        setContentView(R.layout.activity_main);

        // Find the Spinner widget from the layout by its ID
        Spinner spinner = findViewById(R.id.spinner1);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Set the listener that will respond to user selections
        spinner.setOnItemSelectedListener(this);
    }

    // This method is called when an item in the spinner is selected
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Get the selected item text from the spinner
        String text = parent.getItemAtPosition(position).toString();

        // Display the selected item text in a Toast message
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    // This method is called when nothing is selected, but we don't need to do anything here
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // No action needed
    }
}

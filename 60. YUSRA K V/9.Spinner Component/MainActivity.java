package com.example.spinner;

// Importing necessary Android libraries
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

// MainActivity class that implements the OnItemSelectedListener interface
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the layout file activity_main.xml as the UI

        // Step 1: Find the Spinner view from the layout using its ID
        Spinner spinner = findViewById(R.id.spinner1);

        // Step 2: Create an ArrayAdapter using the string array (R.array.numbers) from strings.xml
        // and a default spinner layout provided by Android
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.numbers, // This refers to the array defined in res/values/strings.xml
                android.R.layout.simple_spinner_item // Layout for each item in spinner
        );

        // Step 3: Specify the layout to use when the list of choices appears (dropdown style)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Step 4: Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Step 5: Set the listener for the spinner — this will handle item selection events
        spinner.setOnItemSelectedListener(this);
    }

    // This method is called automatically whenever an item is selected in the spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Get the selected item text
        String text = parent.getItemAtPosition(position).toString();

        // Display a short message (Toast) showing the selected item
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    // This method is called when nothing is selected (not commonly used)
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // You can leave this empty or show a message if needed
    }
}

package com.example.spinner;
// Package name — defines the namespace of your app (folder structure)

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// MainActivity extends AppCompatActivity, which gives access to Android activity features
// It also implements AdapterView.OnItemSelectedListener to handle spinner item selections
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Calls the parent class's onCreate method (required in every activity)

        EdgeToEdge.enable(this);
        // Enables "edge-to-edge" layout display (content can go behind system bars)

        setContentView(R.layout.activity_main);
        // Sets the XML layout for this activity (activity_main.xml)

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        // Finds the Spinner view by its ID from the XML layout

        // Creates an ArrayAdapter using a string array (R.array.numbers) and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,                     // Context (current Activity)
                R.array.numbers,           // String array resource (defined in res/values/strings.xml)
                android.R.layout.simple_spinner_item // Default spinner item layout
        );

        // Specifies the layout to use when the dropdown list appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Attaches the adapter to the Spinner
        spinner.setAdapter(adapter);

        // Sets the listener to handle item selection events
        spinner.setOnItemSelectedListener(this);

        // Handles system UI (status/navigation bars) padding automatically
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // Adjusts padding so content is not hidden by system bars
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Called whenever an item is selected in the spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        // Gets the selected item text as a string

        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        // Displays a short popup message showing the selected item
    }

    // Called when no item is selected (optional)
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // You can leave this empty or handle it if needed
    }
}

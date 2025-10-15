package com.example.spinner;

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


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Sets the content view to the layout
        setContentView(R.layout.activity_main);

        // Find the Spinner view by its ID
        Spinner spinner=(Spinner) findViewById(R.id.spinner1);

        // Create an ArrayAdapter using the string array resource
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.numbers, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinn
        spinner.setAdapter(adapter);

        // Set the listener to handle item selection
        spinner.setOnItemSelectedListener(this);

        // Handle system window insets to prevent UI overlap
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    
    // Called when an item in the Spinner is selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // Get the selected item text
        String text=parent.getItemAtPosition(position).toString();

        // Show a Toast message with the selected item
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    // Called when nothing is selected in the Spinner (not commonly used)
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

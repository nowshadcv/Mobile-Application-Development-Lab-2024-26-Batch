package com.example.sp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // connects this code to the layout file
        setContentView(R.layout.activity_main);
        // find the spinner in our layout
        Spinner spinner = findViewById(R.id.spinner1);
        // create an adapter to hold the list of numbers from strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        // set the style for the dropdown menu
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // apply the adapter to the spinner
        spinner.setAdapter(adapter);
        // tell the spinner to call a method in this class when an item is selected
        spinner.setOnItemSelectedListener(this);
    } 
    // this method is called when we select something from the spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // get the text of the selected item
        String selectedItem = parent.getItemAtPosition(position).toString();
        // make a little popup to show what we picked
        Toast.makeText(parent.getContext(), selectedItem, Toast.LENGTH_SHORT).show();
    }
    // have to include this method, but we don't need to do anything with it
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}

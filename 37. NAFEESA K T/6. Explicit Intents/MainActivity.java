package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onIndexSendbuttonClicked(View view){
        Intent intent = new Intent(this,MainActivity_2.class);
        EditText editText = (EditText) findViewById(R.id.text);
        String index = editText.getText().toString();
        intent.putExtra("ImageIndex",index);
        startActivity(intent);

    }
}

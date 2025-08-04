package com.example.alc2025;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","onCreate invoked");
    }
    protected void onStart() {
        super.onStart();
        Log.d("Life Cycle", "onStart invoked");
    }
    protected void onResume(){
        super.onResume();
        Log.d("Life Cycle","onResume invoked");

    }
    protected void onPause(){
        super.onPause();
        Log.d("Life Cycle","onPause invoked");

    }
    protected void onStop(){
        super.onStop();
        Log.d("Life Cycle","onStop invoked");

    }
    protected void onRestart() {
        super.onRestart();
        Log.d("Life Cycle", "onRestart invoked");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Life Cycle","onDestroy invoked");

    }
}

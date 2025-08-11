package com.example.alc2025;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","onCreate invoke");
    }

    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoke");
    }

    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume invoke");
    }

    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause invoke");
    }

    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoke");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoke");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoke");
    }
}

package com.example.alc2025;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("life Cycle", "onCreate Invoked");
    }
    protected void onStart()
    {
        super.onStart();
        Log.d("life Cycle","onStart Invoked");
    }
    protected void onResume(){
        super.onResume();
        Log.d("life Cycle","onResume Invoked");
    }
    protected void onPause(){
        super.onPause();
        Log.d("life Cycle"," onPause Invoked");
    }
    protected void onStop(){
        super.onStop();
        Log.d("life Cycle","onStop Invoked");
    }
    protected void onRestart(){
        super.onRestart();
        Log.d("life Cycle","onRestart Invoked");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("life Cycle","onDestroy Invoked");
    }
}

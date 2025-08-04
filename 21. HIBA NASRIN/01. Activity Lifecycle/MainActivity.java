package com.example.alc2025;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","onCreate Invoked");
    }
    protected void onStart(){
        super.onStart();
        Log.d("lifecycle","onStart Invoked");
    }
    protected void onResume(){
        super.onResume();
        Log.d("lifecycle","onResume Invoked");
    }
    protected void onPause(){
        super.onPause();
        Log.d("lifecycle","onPause Invoked");
    }
    protected void onStop(){
        super.onStop();
        Log.d("lifecycle","onStop Invoked");
    }
    protected void onRestart(){
        super.onRestart();
        Log.d("lifecycle","onRestart Invoked");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("lifecycle","onDestroy Invoked");
    }
}

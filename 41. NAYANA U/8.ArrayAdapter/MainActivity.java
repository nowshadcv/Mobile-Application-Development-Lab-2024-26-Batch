package com.example.array_adaptor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String fruitlist[]={"Apple","Banana","Dates","Orange","Pomegranate",};
    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=(ListView) findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.activity_listview,R.id.textview,fruitlist);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
             @Override
            public void onItemClick(AdapterView<?> adapterView, View view,int position,long l){
                 Log.i("ListView", "Item is clicked @position"+position);
                 if(position==0)
                 {
                     startActivity(new Intent(MainActivity.this, Apple.class));
                 }
                 else if (position==1)
                 {
                     startActivity(new Intent(MainActivity.this, Banana.class));
                 }
                 else if (position==2)
                 {
                     startActivity(new Intent(MainActivity.this, Dates.class));

                 }
                 else if(position==3)
                 {
                     startActivity(new Intent(MainActivity.this, Orange.class));

                 }
                 else if (position==4)
                     startActivity(new Intent(MainActivity.this, Pomegranate.class));
             }
        });
    }
}
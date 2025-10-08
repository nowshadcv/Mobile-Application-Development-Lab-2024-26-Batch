package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String birdlist[]={"peacock","parrot","duck","kingFisher"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.list_item);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,R.layout.activity_listview,R.id.text,birdlist);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.i("ListView","Item is clicked @ position " +position);
                if(position==0){
                    startActivity(new Intent(MainActivity.this, peacock.class));
                }
                else if (position==1) {
                    startActivity(new Intent(MainActivity.this, parrot.class));
                }
                else if (position==2) {
                    startActivity(new Intent(MainActivity.this, duck.class));
                }
                else if (position==3) {
                    startActivity(new Intent(MainActivity.this, kingFisher.class));
                }
            }
        });
    }
}
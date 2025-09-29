package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String imgindex = bundle.getString("ImageIndex");
            setImage(imgindex);
        }
    }
    private void setImage(String index){
        ImageView i = findViewById(R.id.img1);
        switch (index){
            case "1":
                i.setImageResource(R.drawable.pedri);
                break;
            case "2":
                i.setImageResource(R.drawable.modric);
                break;
            case "3":
                i.setImageResource(R.drawable.kounde);
                break;
            case "4":
                i.setImageResource(R.drawable.dembouz);
                break;
        }
    }
}
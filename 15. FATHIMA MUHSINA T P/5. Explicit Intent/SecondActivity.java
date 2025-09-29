package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            String imgindex=bundle.getString("ImageIndex");
            setImage(imgindex);
        }
    }
    private void setImage(String imgindex){
        ImageView imageView=(ImageView) findViewById(R.id.img1);
        switch(imgindex){
            case "1":
                imageView.setImageResource(R.drawable.rose);
                break;
            case "2":
                imageView.setImageResource(R.drawable.lotus);
                break;
            case "3":
                imageView.setImageResource(R.drawable.tulip);
                break;
            case "4":
                imageView.setImageResource(R.drawable.daliya);
                break;
        }
    }
}
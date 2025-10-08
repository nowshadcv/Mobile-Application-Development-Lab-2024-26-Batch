package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {
            String index = bundle.getString("ImageIndex");
            if (index != null) {
                setImage(index);
            }
        }
    }

    private void setImage(String index)
    {
        ImageView imageView=findViewById(R.id.img1);
        switch(index){
            case "1":
                imageView.setImageResource(R.drawable.fazal);
                break;
            case "2":
                imageView.setImageResource(R.drawable.sura);
                break;
            case "3":
                imageView.setImageResource(R.drawable.ansar);
                break;
            case "4":
                imageView.setImageResource(R.drawable.nihal);
                break;
        }
    }
}
package com.example.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String imgindex = bundle.getString("ImageIndex");
            setImage(imgindex);
        }
    }

    private void setImage(String imgindex) {
        ImageView imageView = (ImageView) findViewById(R.id.img1);
        switch (imgindex) {
            case "1":
                imageView.setImageResource(R.drawable.apple);
                break;
            case "2":
                imageView.setImageResource(R.drawable.orange);
                break;
            case "3":
                imageView.setImageResource(R.drawable.pineapple);
                break;
            case "4":
                imageView.setImageResource(R.drawable.pomagrantes);
                break;
        }
    }
}

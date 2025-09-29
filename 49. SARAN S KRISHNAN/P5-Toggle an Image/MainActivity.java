package com.example.toggleinimage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img1, img2, img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        img1.setOnClickListener(this::onClick);
        img2.setOnClickListener(this::onClick);
        img3.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.img1) {
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.VISIBLE);
        } else if (v.getId() == R.id.img2) {
            img2.setVisibility(View.GONE);
            img3.setVisibility(View.VISIBLE);
        } else {
            img1.setVisibility(View.VISIBLE);
            img3.setVisibility(View.GONE);
        }
    }
}

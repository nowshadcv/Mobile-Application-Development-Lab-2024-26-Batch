package com.example.explicit_intent3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle=getIntent().getExtras();
        if(bundle != null) {
            String imgindex = bundle.getString("ImageIndex");
            setImage(imgindex);
        }
    }
    private void setImage(String index) {
        ImageView imageView = (ImageView) findViewById(R.id.img1);
        switch (index) {
            case "1":
                imageView.setImageResource(R.drawable.apple);
                break;
            case "2":
                imageView.setImageResource(R.drawable.pip);
        }

    }
}





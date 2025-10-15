package com.example.intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String imgindex=bundle.getString("ImageIndex");
            setImage(imgindex);

        }
    }

    private void setImage(String index) {
        ImageView imageView=(ImageView) findViewById(R.id.img1);
        switch (index) {
            case "1":
                imageView.setImageResource(R.drawable.apple1);
                break;
            case "2":
                imageView.setImageResource(R.drawable.pineapple1);
                break;
            case "3":
                imageView.setImageResource(R.drawable.orange1);
                break;
            case "4":
                imageView.setImageResource(R.drawable.pomegranate1);
                break;
        }
    }
}

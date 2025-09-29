package com.example.explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            String imgindex=bundle.getString("ImageIndex");
            setImage(imgindex);

        }
    }
    private void setImage(String imgindex){
        ImageView imageView=(ImageView) findViewById(R.id.img1);
        switch(imgindex){
            case "1" :
                imageView.setImageResource(R.drawable.img2);
                break;
            case "2" :
                imageView.setImageResource(R.drawable.img3);
                break;
            case "3" :
                imageView.setImageResource(R.drawable.img4);
                break;
            case "4" :
                imageView.setImageResource(R.drawable.img5);
                break;
        }
    }
}

package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttondot, buttonadd, buttonsub, buttondiv, buttonmul, buttonC, buttoneql;
    EditText result;

    float mvalueone, mvaluetwo;
    boolean add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonC = findViewById(R.id.buttonC);
        buttondot = findViewById(R.id.buttondot);
        buttonadd = findViewById(R.id.buttonadd);
        buttonsub = findViewById(R.id.buttonsub);
        buttonmul = findViewById(R.id.buttonmul);
        buttondiv = findViewById(R.id.buttondiv);
        buttoneql = findViewById(R.id.buttoneql);
        result = findViewById(R.id.edit1);

        View.OnClickListener numberListener = v -> {
            Button b = (Button) v;
            result.setText(result.getText().toString() + b.getText().toString());
        };

        button0.setOnClickListener(numberListener);
        button1.setOnClickListener(numberListener);
        button2.setOnClickListener(numberListener);
        button3.setOnClickListener(numberListener);
        button4.setOnClickListener(numberListener);
        button5.setOnClickListener(numberListener);
        button6.setOnClickListener(numberListener);
        button7.setOnClickListener(numberListener);
        button8.setOnClickListener(numberListener);
        button9.setOnClickListener(numberListener);
        buttondot.setOnClickListener(numberListener);

        buttonC.setOnClickListener(v -> result.setText(""));

        buttonadd.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mvalueone = Float.parseFloat(result.getText().toString());
                add = true;
                result.setText("");
            }
        });

        buttonsub.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mvalueone = Float.parseFloat(result.getText().toString());
                sub = true;
                result.setText("");
            }
        });

        buttonmul.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mvalueone = Float.parseFloat(result.getText().toString());
                mul = true;
                result.setText("");
            }
        });

        buttondiv.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mvalueone = Float.parseFloat(result.getText().toString());
                div = true;
                result.setText("");
            }
        });

        buttoneql.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mvaluetwo = Float.parseFloat(result.getText().toString());
                if (add) {
                    result.setText(String.valueOf(mvalueone + mvaluetwo));
                    add = false;
                } else if (sub) {
                    result.setText(String.valueOf(mvalueone - mvaluetwo));
                    sub = false;
                } else if (mul) {
                    result.setText(String.valueOf(mvalueone * mvaluetwo));
                    mul = false;
                } else if (div) {
                    if (mvaluetwo != 0) {
                        result.setText(String.valueOf(mvalueone / mvaluetwo));
                    } else {
                        result.setText("Error");
                    }
                    div = false;
                }
            }
        });
    }
}

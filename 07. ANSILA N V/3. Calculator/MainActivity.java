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
        result = findViewById(R.id.edt1);

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                result.append(b.getText());
            }
        };

        button0.setOnClickListener(numberClickListener);
        button1.setOnClickListener(numberClickListener);
        button2.setOnClickListener(numberClickListener);
        button3.setOnClickListener(numberClickListener);
        button4.setOnClickListener(numberClickListener);
        button5.setOnClickListener(numberClickListener);
        button6.setOnClickListener(numberClickListener);
        button7.setOnClickListener(numberClickListener);
        button8.setOnClickListener(numberClickListener);
        button9.setOnClickListener(numberClickListener);
        buttondot.setOnClickListener(numberClickListener);

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
            }
        });

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = result.getText().toString().trim();
                if (!input.isEmpty()) {
                    mvalueone = Float.parseFloat(input);
                    add = true;
                    result.setText("");
                }
            }
        });

        buttonsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = result.getText().toString().trim();
                if (!input.isEmpty()) {
                    mvalueone = Float.parseFloat(input);
                    sub = true;
                    result.setText("");
                }
            }
        });

        buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = result.getText().toString().trim();
                if (!input.isEmpty()) {
                    mvalueone = Float.parseFloat(input);
                    mul = true;
                    result.setText("");
                }
            }
        });

        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = result.getText().toString().trim();
                if (!input.isEmpty()) {
                    mvalueone = Float.parseFloat(input);
                    div = true;
                    result.setText("");
                }
            }
        });

        buttoneql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = result.getText().toString().trim();
                if (!input.isEmpty()) {
                    mvaluetwo = Float.parseFloat(input);
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
            }
        });
    }
}

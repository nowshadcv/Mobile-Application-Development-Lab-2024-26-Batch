package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5,
            button6, button7, button8, button9, buttondot, buttonadd,
            buttonsub, buttondiv, buttonmul, buttonC, buttoneql;
    EditText result;
    float mValueOne, mValueTwo;
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
        buttondot = findViewById(R.id.buttondot);
        buttonadd = findViewById(R.id.buttonadd);
        buttonsub = findViewById(R.id.buttonsub);
        buttonmul = findViewById(R.id.buttonmul);
        buttondiv = findViewById(R.id.buttondiv);
        buttonC = findViewById(R.id.buttonC);
        buttoneql = findViewById(R.id.buttoneql);
        result = findViewById(R.id.edt1);

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                result.append(b.getText());
            }
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

        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = result.getText().toString();
                // Only add dot if not already present
                if (!currentText.contains(".")) {
                    if (currentText.isEmpty()) {
                        // If empty, add "0." for decimal
                        result.append("0.");
                    } else {
                        result.append(".");
                    }
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                add = sub = mul = div = false; // reset operations
            }
        });

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValid()) {
                    mValueOne = Float.parseFloat(result.getText().toString());
                    add = true;
                    sub = mul = div = false;
                    result.setText("");
                }
            }
        });

        buttonsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValid()) {
                    mValueOne = Float.parseFloat(result.getText().toString());
                    sub = true;
                    add = mul = div = false;
                    result.setText("");
                }
            }
        });

        buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValid()) {
                    mValueOne = Float.parseFloat(result.getText().toString());
                    mul = true;
                    add = sub = div = false;
                    result.setText("");
                }
            }
        });

        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValid()) {
                    mValueOne = Float.parseFloat(result.getText().toString());
                    div = true;
                    add = sub = mul = false;
                    result.setText("");
                }
            }
        });

        buttoneql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValid()) {
                    mValueTwo = Float.parseFloat(result.getText().toString());

                    if (add) {
                        result.setText(String.valueOf(mValueOne + mValueTwo));
                        add = false;
                    } else if (sub) {
                        result.setText(String.valueOf(mValueOne - mValueTwo));
                        sub = false;
                    } else if (mul) {
                        result.setText(String.valueOf(mValueOne * mValueTwo));
                        mul = false;
                    } else if (div) {
                        if (mValueTwo == 0) {
                            Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                            result.setText("");
                        } else {
                            result.setText(String.valueOf(mValueOne / mValueTwo));
                        }
                        div = false;
                    }
                }
            }
        });
    }

    private boolean isInputValid() {
        String input = result.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}

package com.example.calculator;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText display;
    double num1 = 0, num2 = 0;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // Number Buttons
        int[] numberIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
        View.OnClickListener numListener = v -> {
            Button b = (Button) v;
            display.append(b.getText());
        };
        for (int id : numberIds) findViewById(id).setOnClickListener(numListener);

        // Operators
        findViewById(R.id.btnAdd).setOnClickListener(v -> setOperator('+'));
        findViewById(R.id.btnSub).setOnClickListener(v -> setOperator('-'));
        findViewById(R.id.btnMul).setOnClickListener(v -> setOperator('*'));
        findViewById(R.id.btnDiv).setOnClickListener(v -> setOperator('/'));

        // Equal
        findViewById(R.id.btnEqual).setOnClickListener(v -> calculate());

        // Clear
        findViewById(R.id.btnClear).setOnClickListener(v -> display.setText(""));
    }

    void setOperator(char op) {
        num1 = Double.parseDouble(display.getText().toString());
        operator = op;
        display.setText("");
    }

    void calculate() {
        num2 = Double.parseDouble(display.getText().toString());
        double result = 0;

        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 == 0) {
                    display.setText("Error");
                    return;
                } else result = num1 / num2;
                break;
        }
        display.setText(String.valueOf(result));
    }
}

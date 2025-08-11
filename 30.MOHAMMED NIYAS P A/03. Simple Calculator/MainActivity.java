package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttondot,buttonadd,buttonsub,buttondiv,buttonmul,buttonC,buttoneql;
    EditText result;
    float mvalueone,mvaluetwo;
    boolean add,sub,mul,div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0=(Button) findViewById(R.id.button0);
        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);
        button5=(Button) findViewById(R.id.button5);
        button6=(Button) findViewById(R.id.button6);
        button7=(Button) findViewById(R.id.button7);
        button8=(Button) findViewById(R.id.button8);
        button9=(Button) findViewById(R.id.button9);
        buttonC=(Button) findViewById(R.id.buttonC);
        buttondot=(Button) findViewById(R.id.buttondot);
        buttonadd=(Button) findViewById(R.id.buttonadd);
        buttonsub=(Button) findViewById(R.id.buttonsub);
        buttonmul=(Button) findViewById(R.id.buttonmul);
        buttondiv=(Button) findViewById(R.id.buttondiv);
        buttoneql=(Button) findViewById(R.id.buttoneql);
        result=(EditText) findViewById(R.id.edt1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "9");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "0");
            }
        });
        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + ".");
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
            }
        });
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result == null) {
                    result.setText("");
                }
                else {
                    mvalueone = Float.parseFloat(result.getText()+" ");
                    add = true;
                    result.setText(null);
                }
            }
        });
        buttonsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result == null) {
                    result.setText("");
                }
                else {
                    mvalueone = Float.parseFloat(result.getText()+" ");
                    sub = true;
                    result.setText(null);
                }
            }
        });
        buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result == null) {
                    result.setText("");
                }
                else {
                    mvalueone = Float.parseFloat(result.getText()+" ");
                    mul = true;
                    result.setText(null);
                }
            }
        });
        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result == null) {
                    result.setText("");
                }
                else {
                    mvalueone = Float.parseFloat(result.getText()+" ");
                    div = true;
                    result.setText(null);
                }
            }
        });
        buttoneql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mvaluetwo = Float.parseFloat(result.getText()+" ");
                if( add==true) {
                    result.setText(mvalueone+mvaluetwo+"");
                    add = false;
                }
                if( sub==true) {
                    result.setText(mvalueone-mvaluetwo+"");
                    sub = false;
                }
                if( mul==true) {
                    result.setText(mvalueone*mvaluetwo+"");
                    mul = false;
                }
                if( div==true) {
                    result.setText(mvalueone/mvaluetwo+"");
                    div = false;
                }
            }
        });
    } }

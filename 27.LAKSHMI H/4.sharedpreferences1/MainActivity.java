package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText ename, eage, eemail, ephone;
    RadioGroup rgGender;
    RadioButton rb1, rb2, rb3;
    CheckBox ech0, ech1, ech2, ech3;
    Button Register;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ename = findViewById(R.id.name);
        eage = findViewById(R.id.age);
        eemail = findViewById(R.id.email);
        ephone = findViewById(R.id.phone);
        rgGender = findViewById(R.id.rggender);
        rb1 = findViewById(R.id.rdbtn1);
        rb2 = findViewById(R.id.rdbtn2);
        rb3 = findViewById(R.id.rdbtn3);
        ech0 = findViewById(R.id.ch0);
        ech1 = findViewById(R.id.ch1);
        ech2 = findViewById(R.id.ch2);
        ech3 = findViewById(R.id.ch3);
        Register = findViewById(R.id.loginbtn);

        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // ✅ Save data when button clicked (your existing code)
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }
    private void registerUser(){
        String name = ename.getText().toString().trim();
        String age = eage.getText().toString().trim();
        String email = eemail.getText().toString().trim();
        String phone = ephone.getText().toString().trim();

        if(name.isEmpty())

        {
            ename.setError("Enter name");
            ename.requestFocus();
            return;
        }
        if(age.isEmpty())

        {
            ename.setError("Enter age");
            ename.requestFocus();
            return;
        }
        if(email.isEmpty())

        {
            ename.setError("Enter email");
            ename.requestFocus();
            return;
        }
        if(phone.isEmpty())

        {
            ename.setError("Enter phone number");
            ename.requestFocus();
            return;
        }

        int selectedId = rgGender.getCheckedRadioButtonId();
        String gender = "";
        if(selectedId !=-1)

        {
            RadioButton selectedGender = findViewById(selectedId);
            gender = selectedGender.getText().toString();
        }

        StringBuilder subjects = new StringBuilder();
        if(ech0.isChecked())subjects.append("Mathematics ");
        if(ech1.isChecked())subjects.append("Science ");
        if(ech2.isChecked())subjects.append("English ");
        if(ech3.isChecked())subjects.append("History ");

        editor.putString("name",name);
        editor.putString("age",age);
        editor.putString("email",email);
        editor.putString("phone",phone);
        editor.putString("gender",gender);
        editor.putString("subject",subjects.toString());
        editor.apply();

        Toast.makeText(this,"Registered successfully :)",Toast.LENGTH_LONG).show();
    }
}

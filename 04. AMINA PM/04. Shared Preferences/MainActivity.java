package com.example.sharedprefernce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, age, phone, address;
    RadioGroup genderGroup;
    CheckBox java, python, cpp, flutter;
    Button submitBtn;

    SharedPreferences signupFormPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        genderGroup = findViewById(R.id.genderGroup);
        java = findViewById(R.id.java);
        python = findViewById(R.id.python);
        cpp = findViewById(R.id.cpp);
        flutter = findViewById(R.id.flt);
        submitBtn = findViewById(R.id.submitBtn);

        // Initialize SharedPreferences
        signupFormPrefs = getSharedPreferences("UserDetails", MODE_PRIVATE);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString().trim();
                String userAge = age.getText().toString().trim();
                String userPhone = phone.getText().toString().trim();
                String userAddress = address.getText().toString().trim();

                int selectedGenderId = genderGroup.getCheckedRadioButtonId();
                String gender = "";
                if (selectedGenderId != -1) {
                    RadioButton selectedGender = findViewById(selectedGenderId);
                    gender = selectedGender.getText().toString();
                }

                StringBuilder languages = new StringBuilder();
                if (java.isChecked()) languages.append("Java ");
                if (python.isChecked()) languages.append("Python ");
                if (cpp.isChecked()) languages.append("C++ ");
                if (flutter.isChecked()) languages.append("Flutter ");

                if (userName.isEmpty() || userAge.isEmpty() || userPhone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Signup Unsuccessful: Please fill all fields", Toast.LENGTH_LONG).show();
                    return;
                }

                // Save data to SharedPreferences
                SharedPreferences.Editor editor = signupFormPrefs.edit();
                editor.putString("Name", userName);
                editor.putString("Age", userAge);
                editor.putString("Phone", userPhone);
                editor.putString("Address", userAddress);
                editor.putString("Gender", gender);
                editor.putString("Languages", languages.toString().trim());
                editor.apply();

                Toast.makeText(MainActivity.this, "Signup successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}

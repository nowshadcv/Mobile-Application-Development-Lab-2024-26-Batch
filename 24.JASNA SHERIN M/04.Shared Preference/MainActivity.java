package com.example.sharedpreference;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge, etEmail, etPhone;
    RadioGroup radioGroupGender;
    RadioButton rbMale, rbFemale, rbOther;
    CheckBox cbMath, cbScience, cbEnglish, cbHistory;
    Button btnRegister;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);

        radioGroupGender = findViewById(R.id.radioGroupGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbOther = findViewById(R.id.rbOther);

        cbMath = findViewById(R.id.cbMath);
        cbScience = findViewById(R.id.cbScience);
        cbEnglish = findViewById(R.id.cbEnglish);
        cbHistory = findViewById(R.id.cbHistory);

        btnRegister = findViewById(R.id.btnRegister);

        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String name = etName.getText().toString().trim();
        String age = etAge.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();

        if (name.isEmpty()) {
            etName.setError("Enter Name");
            etName.requestFocus();
            return;
        }
        if (age.isEmpty()) {
            etAge.setError("Enter Age");
            etAge.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            etEmail.setError("Enter Email");
            etEmail.requestFocus();
            return;
        }
        if (phone.isEmpty()) {
            etPhone.setError("Enter Phone");
            etPhone.requestFocus();
            return;
        }

        String gender = "";
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedRadio = findViewById(selectedId);
            gender = selectedRadio.getText().toString();
        }

        StringBuilder subjects = new StringBuilder();
        if (cbMath.isChecked()) subjects.append("Mathematics ");
        if (cbScience.isChecked()) subjects.append("Science ");
        if (cbEnglish.isChecked()) subjects.append("English ");
        if (cbHistory.isChecked()) subjects.append("History ");

        editor.putString("name", name);
        editor.putString("age", age);
        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.putString("gender", gender);
        editor.putString("subjects", subjects.toString());
        editor.apply();

        Toast.makeText(this,
                "Registration Successful",
                Toast.LENGTH_LONG).show();
    }
}

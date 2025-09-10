package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge, etEmail, etMobile;
    RadioGroup radioGender;
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
        etMobile = findViewById(R.id.etMobile);

        radioGender = findViewById(R.id.radioGender);

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
                String name = etName.getText().toString().trim();
                String age = etAge.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String mobile = etMobile.getText().toString().trim();

                int selectedGenderId = radioGender.getCheckedRadioButtonId();
                RadioButton selectedGender = findViewById(selectedGenderId);
                String gender = (selectedGender != null) ? selectedGender.getText().toString() : "";

                StringBuilder subjects = new StringBuilder();
                if (cbMath.isChecked()) subjects.append("Mathematics ");
                if (cbScience.isChecked()) subjects.append("Science ");
                if (cbEnglish.isChecked()) subjects.append("English ");
                if (cbHistory.isChecked()) subjects.append("History ");

                // Save data in SharedPreferences
                editor.putString("keyName", name);
                editor.putString("keyAge", age);
                editor.putString("keyEmail", email);
                editor.putString("keyMobile", mobile);
                editor.putString("keyGender", gender);
                editor.putString("keySubjects", subjects.toString().trim());
                editor.apply();

                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

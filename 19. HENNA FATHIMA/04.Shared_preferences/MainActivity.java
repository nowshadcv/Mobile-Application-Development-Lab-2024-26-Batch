package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameInput, ageInput, emailInput, phoneInput;
    RadioGroup genderGroup;
    CheckBox mathCheckBox, englishCheckBox, historyCheckBox, scienceCheckBox;
    Button registerButton;

    private static final String PREF_NAME = "UserDetails";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.editTextName);
        ageInput = findViewById(R.id.editTextAge);
        emailInput = findViewById(R.id.editTextEmail);
        phoneInput = findViewById(R.id.editTextPhone);
        genderGroup = findViewById(R.id.radioGroupGender);
        mathCheckBox = findViewById(R.id.checkBoxMath);
        englishCheckBox = findViewById(R.id.checkBoxEnglish);
        historyCheckBox = findViewById(R.id.checkBoxHistory);
        scienceCheckBox = findViewById(R.id.checkBoxScience);
        registerButton = findViewById(R.id.buttonRegister);

        loadData();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String name = nameInput.getText().toString();
        String age = ageInput.getText().toString();
        String email = emailInput.getText().toString();
        String phone = phoneInput.getText().toString();

        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (age.isEmpty()) {
            Toast.makeText(this, "Please enter your age", Toast.LENGTH_SHORT).show();
            return;
        }
        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (phone.isEmpty()) {
            Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        int selectedGenderId = genderGroup.getCheckedRadioButtonId();
        if (selectedGenderId == -1) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton selectedGenderButton = findViewById(selectedGenderId);
        String gender = selectedGenderButton.getText().toString();

        String subjects = "";
        if (mathCheckBox.isChecked()) subjects += "Mathematics ";
        if (englishCheckBox.isChecked()) subjects += "English ";
        if (historyCheckBox.isChecked()) subjects += "History ";
        if (scienceCheckBox.isChecked()) subjects += "Science ";

        if (subjects.isEmpty()) {
            Toast.makeText(this, "Please select at least one subject", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putString("keyname", name);
        editor.putString("keyage", age);
        editor.putString("keyemail", email);
        editor.putString("keyphone", phone);
        editor.putString("keygender", gender);
        editor.putString("keysubjects", subjects);
        editor.apply();

        Toast.makeText(this, "Registration Successful! Data Saved.", Toast.LENGTH_LONG).show();

        clearForm();
    }

    private void clearForm() {
        nameInput.setText("");
        ageInput.setText("");
        emailInput.setText("");
        phoneInput.setText("");
        genderGroup.clearCheck();
        mathCheckBox.setChecked(false);
        englishCheckBox.setChecked(false);
        historyCheckBox.setChecked(false);
        scienceCheckBox.setChecked(false);
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        String name = sharedPreferences.getString("keyname", "");
        String age = sharedPreferences.getString("keyage", "");
        String email = sharedPreferences.getString("keyemail", "");
        String phone = sharedPreferences.getString("keyphone", "");
        String gender = sharedPreferences.getString("keygender", "");
        String subjects = sharedPreferences.getString("keysubjects", "");

        nameInput.setText(name);
        ageInput.setText(age);
        emailInput.setText(email);
        phoneInput.setText(phone);

        if (gender.equals("Male")) {
            genderGroup.check(R.id.radioButtonMale);
        } else if (gender.equals("Female")) {
            genderGroup.check(R.id.radioButtonFemale);
        } else if (gender.equals("Other")) {
            genderGroup.check(R.id.radioButtonOther);
        }

        if (subjects.contains("Mathematics")) mathCheckBox.setChecked(true);
        if (subjects.contains("English")) englishCheckBox.setChecked(true);
        if (subjects.contains("History")) historyCheckBox.setChecked(true);
        if (subjects.contains("Science")) scienceCheckBox.setChecked(true);
    }
}

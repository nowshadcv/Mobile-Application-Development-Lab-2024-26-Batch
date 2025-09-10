package com.example.sharedprefereence1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText, numberEditText, emailEditText, phoneEditText;
    RadioButton radioMale, radioFemale, radioOther;
    CheckBox checkMath, checkScience, checkEnglish, checkHistory;
    Button submitButton;

    SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "UserData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        nameEditText = findViewById(R.id.editTextText5);
        numberEditText = findViewById(R.id.editTextNumberSigned);
        emailEditText = findViewById(R.id.editTextTextEmailAddress2);
        phoneEditText = findViewById(R.id.editTextPhone);

        radioMale = findViewById(R.id.radioButton);
        radioFemale = findViewById(R.id.radioButton2);
        radioOther = findViewById(R.id.radioButton3);

        checkMath = findViewById(R.id.checkBox);
        checkScience = findViewById(R.id.checkBox2);
        checkEnglish = findViewById(R.id.checkBox3);
        checkHistory = findViewById(R.id.checkBox4);

        submitButton = findViewById(R.id.button);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        loadData();  
        
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    private void saveData() {
        String name = nameEditText.getText().toString().trim();
        String number = numberEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        
        if (name.isEmpty()) {
            nameEditText.setError("Please enter your name");
            nameEditText.requestFocus();
            return;
        }

        if (number.isEmpty()) {
            numberEditText.setError("Please enter your number");
            numberEditText.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            emailEditText.setError("Please enter your email");
            emailEditText.requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            phoneEditText.setError("Please enter your phone number");
            phoneEditText.requestFocus();
            return;
        }
        
        String gender = "";
        if (radioMale.isChecked()) {
            gender = "Male";
        } else if (radioFemale.isChecked()) {
            gender = "Female";
        } else if (radioOther.isChecked()) {
            gender = "Other";
        } else {
            Toast.makeText(MainActivity.this, "Please select your gender", Toast.LENGTH_SHORT).show();
            return;
        }
        
        StringBuilder subjects = new StringBuilder();
        if (checkMath.isChecked()) subjects.append("Mathematics,");
        if (checkScience.isChecked()) subjects.append("Science,");
        if (checkEnglish.isChecked()) subjects.append("English,");
        if (checkHistory.isChecked()) subjects.append("History,");

        String selectedSubjects = subjects.length() > 0 ? subjects.toString() : "";
        
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("number", number);
        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.putString("gender", gender);
        editor.putString("subjects", selectedSubjects);
        editor.apply();
        
        String displaySubjects = selectedSubjects.isEmpty() ? "None" : selectedSubjects.replaceAll(",$", "");
        String message = "Name: " + name + "\n" +
                "Number: " + number + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n" +
                "Gender: " + gender + "\n" +
                "Subjects: " + displaySubjects;

        Toast.makeText(MainActivity.this, "Data Saved!\n\n" + message, Toast.LENGTH_LONG).show();
    }

    private void loadData() {
        String name = sharedPreferences.getString("name", "");
        String number = sharedPreferences.getString("number", "");
        String email = sharedPreferences.getString("email", "");
        String phone = sharedPreferences.getString("phone", "");
        String gender = sharedPreferences.getString("gender", "");
        String subjects = sharedPreferences.getString("subjects", "");

        nameEditText.setText(name);
        numberEditText.setText(number);
        emailEditText.setText(email);
        phoneEditText.setText(phone);
        
        if (gender.equals("Male")) {
            radioMale.setChecked(true);
        } else if (gender.equals("Female")) {
            radioFemale.setChecked(true);
        } else if (gender.equals("Other")) {
            radioOther.setChecked(true);
        }
        
        checkMath.setChecked(subjects.contains("Mathematics"));
        checkScience.setChecked(subjects.contains("Science"));
        checkEnglish.setChecked(subjects.contains("English"));
        checkHistory.setChecked(subjects.contains("History"));
    }
}

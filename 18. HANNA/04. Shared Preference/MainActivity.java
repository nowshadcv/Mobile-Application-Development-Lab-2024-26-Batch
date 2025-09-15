package com.example.shared_prefrence;

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

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, rollno, email, mobilenum;
    RadioGroup genderGroup;
    CheckBox subjectMath, subjectScience, subjectEnglish, subjectHistory;
    Button submit;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = (EditText)findViewById(R.id.name);
        rollno = (EditText)findViewById(R.id.rollno);
        email = (EditText)findViewById(R.id.email);
        mobilenum = (EditText)findViewById(R.id.number);
        genderGroup = (RadioGroup)findViewById(R.id.genderGroup);

        subjectMath = (CheckBox)findViewById(R.id.subject_math);
        subjectScience = (CheckBox)findViewById(R.id.subject_science);
        subjectEnglish = (CheckBox)findViewById(R.id.subject_english);
        subjectHistory= (CheckBox)findViewById(R.id.subject_history);

        submit = findViewById(R.id.loginbtn);

        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = name.getText().toString().trim();
                String rollStr = rollno.getText().toString().trim();
                String emailStr = email.getText().toString().trim();
                String mobileStr = mobilenum.getText().toString().trim();


                if (nameStr.isEmpty()) {
                    name.setError("Name is required");
                    name.requestFocus();
                    return;
                }

                if (rollStr.isEmpty()) {
                    rollno.setError("Roll No is required");
                    rollno.requestFocus();
                    return;
                }

                if (emailStr.isEmpty()) {
                    email.setError("Email is required");
                    email.requestFocus();
                    return;
                }

                if (mobileStr.isEmpty()) {
                    mobilenum.setError("Mobile number is required");
                    mobilenum.requestFocus();
                    return;
                }


                int selectedGenderId = genderGroup.getCheckedRadioButtonId();
                String gender = "";
                if (selectedGenderId != -1) {
                    RadioButton selectedGender = findViewById(selectedGenderId);
                    gender = selectedGender.getText().toString();
                } else {
                    Toast.makeText(MainActivity.this, "Please select Gender", Toast.LENGTH_SHORT).show();
                    return;
                }


                StringBuilder subjects = new StringBuilder();
                if (subjectMath.isChecked()) subjects.append("Mathematics ");
                if (subjectScience.isChecked()) subjects.append("Science ");
                if (subjectEnglish.isChecked()) subjects.append("English ");
                if (subjectHistory.isChecked()) subjects.append("History ");

                if (subjects.length() == 0) {
                    Toast.makeText(MainActivity.this, "Please select at least one subject", Toast.LENGTH_SHORT).show();
                    return;
                }


                editor.putString("keyName", nameStr);
                editor.putString("keyRollNo", rollStr);
                editor.putString("keyEmail", emailStr);
                editor.putString("keyMobile", mobileStr);
                editor.putString("keyGender", gender);
                editor.putString("keySubjects", subjects.toString().trim());
                editor.apply();

                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
            }
        });
    }
}
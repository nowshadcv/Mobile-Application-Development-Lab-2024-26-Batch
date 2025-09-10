package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    EditText name, rollno, mail, number;
    RadioGroup genders;
    RadioButton selectedGender;
    CheckBox mathematics, science, history, english;
    MaterialButton loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        rollno = findViewById(R.id.rollno);
        mail = findViewById(R.id.mail);
        number = findViewById(R.id.number);
        genders = findViewById(R.id.genders);
        mathematics = findViewById(R.id.mathematics);
        science = findViewById(R.id.science);
        history = findViewById(R.id.history);
        english = findViewById(R.id.english);
        loginbtn = findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = name.getText().toString().trim();
                String userRoll = rollno.getText().toString().trim();
                String userMail = mail.getText().toString().trim();
                String userNumber = number.getText().toString().trim();

                int selectedId = genders.getCheckedRadioButtonId();
                selectedGender = findViewById(selectedId);
                String gender = selectedGender != null ? selectedGender.getText().toString() : "Not selected";

                StringBuilder subjects = new StringBuilder();
                if (mathematics.isChecked()) subjects.append("Mathematics, ");
                if (science.isChecked()) subjects.append("Science, ");
                if (history.isChecked()) subjects.append("History, ");
                if (english.isChecked()) subjects.append("English");

                SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("name", userName);
                editor.putString("rollno", userRoll);
                editor.putString("email", userMail);
                editor.putString("password", userNumber);
                editor.putString("gender", gender);
                editor.putString("subjects", subjects.toString());
                editor.apply();

                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

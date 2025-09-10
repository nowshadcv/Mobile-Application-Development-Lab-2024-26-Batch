package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge, etEmail, etPhone;
    RadioGroup radioGroupGender;
    CheckBox cbMath, cbScience, cbEnglish, cbHistory;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        cbMath = findViewById(R.id.cbMath);
        cbScience = findViewById(R.id.cbScience);
        cbEnglish = findViewById(R.id.cbEnglish);
        cbHistory = findViewById(R.id.cbHistory);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String email = etEmail.getText().toString();
                String phone = etPhone.getText().toString();

               
                int selectedId = radioGroupGender.getCheckedRadioButtonId();
                String gender = "";
                if (selectedId != -1) {
                    RadioButton selectedRadio = findViewById(selectedId);
                    gender = selectedRadio.getText().toString();
                }

                
                StringBuilder subjects = new StringBuilder();
                if (cbMath.isChecked()) subjects.append("Mathematics ");
                if (cbScience.isChecked()) subjects.append("Science ");
                if (cbEnglish.isChecked()) subjects.append("English ");
                if (cbHistory.isChecked()) subjects.append("History ");

               
                Toast.makeText(MainActivity.this,
                        "Registration Successful",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

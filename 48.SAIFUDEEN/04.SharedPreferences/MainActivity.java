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

    EditText Name, Age, Email, Phone;
    RadioGroup Gender;
    CheckBox Math, Science, English, History;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.Name);
        Age = findViewById(R.id.Age);
        Email = findViewById(R.id.Email);
        Phone = findViewById(R.id.Phone);
        Gender = findViewById(R.id.Gender);
        Math = findViewById(R.id.Math);
        Science = findViewById(R.id.Science);
        English = findViewById(R.id.English);
        History = findViewById(R.id.History);
        Register = findViewById(R.id.Register);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = Name.getText().toString();
                String age = Age.getText().toString();
                String email = Email.getText().toString();
                String phone = Phone.getText().toString();

               
                int Id = Gender.getCheckedRadioButtonId();
                String gender = "";
                if (Id != -1) {
                    RadioButton Radio = findViewById(Id);
                    gender = Radio.getText().toString();
                }

                
                StringBuilder subjects = new StringBuilder();
                if (Math.isChecked()) subjects.append("Mathematics ");
                if (Science.isChecked()) subjects.append("Science ");
                if (English.isChecked()) subjects.append("English ");
                if (History.isChecked()) subjects.append("History ");

               
                Toast.makeText(MainActivity.this,
                        "Registration Successful",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

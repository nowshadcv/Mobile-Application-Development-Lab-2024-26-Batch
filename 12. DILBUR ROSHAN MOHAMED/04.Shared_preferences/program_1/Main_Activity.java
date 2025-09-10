package com.example.preferences;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,mobileno,email,pass1,pass2;
    Button submit;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        username = findViewById(R.id.username);
        mobileno = findViewById(R.id.number);
        email = findViewById(R.id.email);
        pass1 = findViewById(R.id.password);
        pass2 = findViewById(R.id.conpassword);
        submit = findViewById(R.id.loginbtn);

        sharedPreferences = getSharedPreferences("userDetails", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernames = username.getText().toString().trim();
                String mobileStr = mobileno.getText().toString().trim();
                String emails = email.getText().toString().trim();
                String pass1s = pass1.getText().toString().trim();
                String pass2s = pass2.getText().toString().trim();

                if (usernames.isEmpty()) {
                    username.setError("Username is empty");
                    username.requestFocus();
                    return;
                }

                if (mobileStr.isEmpty()) {
                    mobileno.setError("Mobile number is empty");
                    mobileno.requestFocus();
                    return;
                }

                int mobilei;
                try {
                    mobilei = Integer.parseInt(mobileStr);
                } catch (NumberFormatException e) {
                    mobileno.setError("Invalid mobile number");
                    mobileno.requestFocus();
                    return;
                }

                if (emails.isEmpty()) {
                    email.setError("Input email");
                    email.requestFocus();
                    return;
                }

                if (pass1s.isEmpty()) {
                    pass1.setError("Enter password");
                    pass1.requestFocus();
                    return;
                }

                if (pass2s.isEmpty()) {
                    pass2.setError("Confirm your password");
                    pass2.requestFocus();
                    return;
                }

                if (pass1s.length() < 6) {
                    pass1.setError("Password must be at least 6 characters");
                    pass1.requestFocus();
                    return;
                }

                if (!pass1s.equals(pass2s)) {
                    pass2.setError("Passwords do not match");
                    pass2.requestFocus();
                    return;
                }

                Toast.makeText(MainActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();

                editor.putString("keyusername", usernames);
                editor.putInt("keymobile", mobilei);
                editor.putString("keyemail", emails);
                editor.putString("keypassword", pass2s);
                editor.apply();
            }
        });
    }
}

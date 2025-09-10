package com.example.shared_preference;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etAge, etPhone, etEmail;
    RadioGroup rgGender;
    CheckBox cbMath, cbScience, cbEnglish, cbHistory;
    Button btnRegister;

    SharedPreferences prefs;
    static final String PREF_FILE = "UserPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etUsername = findViewById(R.id.etUsername);
        etAge = findViewById(R.id.etAge);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        rgGender = findViewById(R.id.rgGender);
        cbMath = findViewById(R.id.cbMath);
        cbScience = findViewById(R.id.cbScience);
        cbEnglish = findViewById(R.id.cbEnglish);
        cbHistory = findViewById(R.id.cbHistory);
        btnRegister = findViewById(R.id.btnRegister);

        prefs = getSharedPreferences(PREF_FILE, MODE_PRIVATE);



        // Restore saved data
        etUsername.setText(prefs.getString("username", ""));
        etAge.setText(prefs.getString("age", ""));
        etPhone.setText(prefs.getString("phone", ""));
        etEmail.setText(prefs.getString("email", ""));

        int genderId = prefs.getInt("genderId", -1);
        if (genderId != -1) rgGender.check(genderId);

        cbMath.setChecked(prefs.getBoolean("math", false));
        cbScience.setChecked(prefs.getBoolean("science", false));
        cbEnglish.setChecked(prefs.getBoolean("english", false));
        cbHistory.setChecked(prefs.getBoolean("history", false));



        // Save data when button clicked
        btnRegister.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String age = etAge.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String email = etEmail.getText().toString().trim();

            // Validation
            if (username.isEmpty()) {
                etUsername.setError("Username is required!");
                etUsername.requestFocus();
                return;
            }

            if (phone.isEmpty()) {
                etPhone.setError("Phone number is required!");
                etPhone.requestFocus();
                return;
            }

            if (email.isEmpty()) {
                etEmail.setError("Email is required!");
                etEmail.requestFocus();
                return;
            }

            // Save data only if validation passes
            SharedPreferences.Editor editor = prefs.edit();

            editor.putString("username", username);
            editor.putString("age", age);
            editor.putString("phone", phone);
            editor.putString("email", email);

            editor.putInt("genderId", rgGender.getCheckedRadioButtonId());

            editor.putBoolean("math", cbMath.isChecked());
            editor.putBoolean("science", cbScience.isChecked());
            editor.putBoolean("english", cbEnglish.isChecked());
            editor.putBoolean("history", cbHistory.isChecked());

            editor.apply();

            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        });

    }
}

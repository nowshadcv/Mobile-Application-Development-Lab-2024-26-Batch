package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,mobilenum,email,pass1,pass2;

    Button submit;

    SharedPreferences sharedPreference;

    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText) findViewById(R.id.user_name);
        mobilenum=(EditText) findViewById(R.id.numbers);
        email=(EditText) findViewById(R.id.E_mail);
        pass1=(EditText) findViewById(R.id.password);
        pass2=(EditText) findViewById(R.id.conpassword);
        submit=(Button) findViewById(R.id.loginbtn);
        sharedPreference=getSharedPreferences("UserDetails",MODE_PRIVATE);
        editor=sharedPreference.edit();
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String usernames=username.getText().toString().trim();
                int mobiles=Integer.parseInt(mobilenum.getText().toString().trim());
                String emails=email.getText().toString().trim();
                String pass1s=pass1.getText().toString().trim();
                String pass2s=pass2.getText().toString().trim();
                if(usernames.isEmpty())
                {
                    username.setError("Username is Empty");
                    username.requestFocus();
                    return;
                }

                if(emails.isEmpty())
                {
                    email.setError("Input Email");
                    email.requestFocus();
                    return;
                }
                if(pass1s.isEmpty())
                {
                    pass1.setError("Enter password");
                    pass1.requestFocus();
                    return;
                }
                if(pass2s.isEmpty())
                {
                    pass2.setError("Enter password");
                    pass2.requestFocus();
                    return;
                }
                if(pass1s.length()<6)
                {
                    pass1.setError("Length must be minimum 6 character");
                    pass1.requestFocus();
                    return;
                }
                if(!pass1s.equals(pass2s))
                {
                    pass1.setError("password not matched");
                    pass1.requestFocus();
                    return;
                }
                Toast.makeText(MainActivity.this, "Registration successfully", Toast.LENGTH_SHORT).show();
                editor.putString("keyusername",usernames);
                editor.putInt("keymobile",mobiles);
                editor.putString("keyemail",emails);
                editor.putString("keypassword",pass2s);
                editor.apply();
            }
        });
    }
}

package com.example.simplechat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseUser;

public class SignUpActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsername = findViewById(R.id.newUsername);
        etPassword = findViewById(R.id.newPassword);
        submitButton = findViewById(R.id.signUpButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser newUser = new ParseUser();
                newUser.setPassword(etPassword.getText().toString());
                newUser.setUsername(etUsername.getText().toString());
                newUser.signUpInBackground();
                ParseUser.logInInBackground(etUsername.getText().toString(), etPassword.getText().toString());
                Intent i = new Intent(SignUpActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });

    }
}
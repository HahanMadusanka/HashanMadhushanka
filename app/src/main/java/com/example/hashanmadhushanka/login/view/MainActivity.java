package com.example.hashanmadhushanka.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hashanmadhushanka.R;
import com.example.hashanmadhushanka.login.controller.LoginController;

public class MainActivity extends AppCompatActivity {
    LoginController controller;
    public TextView signInPasswordError;
    public EditText userName, password;
    public Button signInButton;
    public ProgressBar progressBarSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new LoginController(this);

        userName = findViewById(R.id.sign_in_username);
        password = findViewById(R.id.sign_in_password);
        progressBarSignIn = findViewById(R.id.progressbar_sign_in);
        signInButton = findViewById(R.id.sign_in_button);
        signInPasswordError = findViewById(R.id.signInPasswordError);
        userName.addTextChangedListener(controller.signInAccountTextWatcher);
        password.addTextChangedListener(controller.signInAccountTextWatcher);

        signInButton.setOnClickListener((view)->{
            controller.login(userName.getText().toString().trim(), password.getText().toString().trim());
        });
    }
}
package com.example.hashanmadhushanka.home.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.hashanmadhushanka.R;
import com.example.hashanmadhushanka.home.controller.HomeController;

public class HomeActivity extends AppCompatActivity {
    HomeController controller;
    Button bViewProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        controller = new HomeController(this);

        bViewProfile = findViewById(R.id.b_view_profile);
        bViewProfile.setOnClickListener((v -> {
            controller.viewProfile();
        }));
    }
}
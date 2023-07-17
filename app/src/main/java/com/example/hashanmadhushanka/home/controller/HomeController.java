package com.example.hashanmadhushanka.home.controller;

import android.content.Intent;

import com.example.hashanmadhushanka.home.model.HomeModel;
import com.example.hashanmadhushanka.home.view.HomeActivity;
import com.example.hashanmadhushanka.profile.view.ProfileActivity;

public class HomeController {
    private HomeActivity view; // view
    private HomeModel model;

    public HomeController(HomeActivity homeActivity) {
        this.view = homeActivity;
        model = new HomeModel(this);
    }

    public void viewProfile() {
        Intent intent = new Intent(view, ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        view.startActivity(intent);
    }
}

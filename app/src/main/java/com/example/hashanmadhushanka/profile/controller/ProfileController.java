package com.example.hashanmadhushanka.profile.controller;

import android.content.Intent;

import com.example.hashanmadhushanka.home.view.HomeActivity;
import com.example.hashanmadhushanka.profile.model.ProfileModel;
import com.example.hashanmadhushanka.profile.view.ProfileActivity;
import com.example.hashanmadhushanka.utils.SharedPreferencesConst;
import com.example.hashanmadhushanka.utils.SharedPreferencesUtil;

public class ProfileController {
    private ProfileActivity view; // view
    private ProfileModel model;
    SharedPreferencesUtil sharedPreferencesUtil;

    public ProfileController(ProfileActivity view) {
        this.view = view;
        model = new ProfileModel(this);
        sharedPreferencesUtil = new SharedPreferencesUtil(view);
    }

    public void viewProfile() {
     view.tvEmail.setText(sharedPreferencesUtil.sharedPreferencesRead(SharedPreferencesConst.EMAIL));
     view.tvName.setText(sharedPreferencesUtil.sharedPreferencesRead(SharedPreferencesConst.NAME));
     view.tvDob.setText(sharedPreferencesUtil.sharedPreferencesRead(SharedPreferencesConst.DOB));
     view.tvGender.setText(sharedPreferencesUtil.sharedPreferencesRead(SharedPreferencesConst.GENDER));
     view.tvCompany.setText(sharedPreferencesUtil.sharedPreferencesRead(SharedPreferencesConst.COMPANY));
     view.tvPosition.setText(sharedPreferencesUtil.sharedPreferencesRead(SharedPreferencesConst.POSITION));
    }
}

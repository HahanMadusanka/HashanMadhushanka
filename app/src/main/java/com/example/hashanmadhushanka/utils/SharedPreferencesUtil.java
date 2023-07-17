package com.example.hashanmadhushanka.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;

public class SharedPreferencesUtil {

    SharedPreferences sp;

    public SharedPreferencesUtil(Context context) {
        sp = context.getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
    }

    public void sharedPreferencesSave(String key, String value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String sharedPreferencesRead(String key) {
        return sp.getString(key, "empty");
    }


}

package com.example.hashanmadhushanka.login.model;


import android.app.DownloadManager;
import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.textclassifier.TextLinks;

import com.example.hashanmadhushanka.login.controller.LoginController;
import com.example.hashanmadhushanka.utils.SharedPreferencesConst;
import com.example.hashanmadhushanka.utils.SharedPreferencesUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginModel {
    private LoginController controller;
    private static final String BASE_URL = "http://123.231.9.43:3999";
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    private final Handler handler = new Handler(Looper.getMainLooper());

    public LoginModel(LoginController mainController) {
        this.controller = mainController;
    }

    public void login(String username, String password) {
        class Class_login implements Runnable {
            @Override
            public void run() {
                try {
                    // Create JSON payload
                    String json = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";

                    RequestBody requestBody = RequestBody.create(JSON_MEDIA_TYPE, json);
                    Request.Builder builder = new Request.Builder();
                    Request request = builder
                            .url(BASE_URL)
                            .post(requestBody)
                            .build();

                    OkHttpClient client = new OkHttpClient().newBuilder().build();
                    Response response = client.newCall(request).execute();


                    if (response.body() != null) {
                        String responseBody = response.body().string();
                        Log.d(ContentValues.TAG, "LoginModel.java --> response " + responseBody);
                        JSONObject jsonObject = new JSONObject(responseBody);
                        int resCode = jsonObject.getInt("res_code");
                        String resDesc = jsonObject.getString("res_desc");
                        if (resCode == 0) {
                            JSONObject userData = jsonObject.getJSONObject("user_data");

                            // Access the values from the inner JSON object (user_data)
                            String id = userData.getString("id");
                            String email = userData.getString("email");
                            String name = userData.getString("name");
                            String dob = userData.getString("dob");
                            String gender = userData.getString("gender");
                            String company = userData.getString("company");
                            String position = userData.getString("position");

                            controller.onSuccess(id, email, name, dob, gender, company, position);


                        } else {
                            controller.onError(resDesc);
                        }
                    } else {
                        controller.onError("Connection error");
                    }

                } catch (Exception e) {
                    controller.onError("Error !");
                    Log.d(ContentValues.TAG, "LoginModel.java --> e " + e);
                    e.printStackTrace();
                }
            }
        }
        Class_login class_login = new Class_login();
        new Thread(class_login).start();
    }

}

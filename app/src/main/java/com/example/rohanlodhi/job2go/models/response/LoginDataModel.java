package com.example.rohanlodhi.job2go.models.response;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginDataModel {
    /**
     * id : 2
     * username : nik
     * password : pooi
     * created_at : 2018-07-11 19:27:05
     */

    public int id;
    public String username;
    public String password;
    public String created_at;

    public static LoginDataModel objectFromData(String str) {

        return new Gson().fromJson(str, LoginDataModel.class);
    }

    public static LoginDataModel objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), LoginDataModel.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}

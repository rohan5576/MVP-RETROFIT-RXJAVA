package com.example.rohanlodhi.job2go.models.response;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpResponseModel {

    /**
     * status : 200
     * msg : Signup successfully
     */

    public int status;
    public String msg;

    public static SignUpResponseModel objectFromData(String str) {

        return new Gson().fromJson(str, SignUpResponseModel.class);
    }

    public static SignUpResponseModel objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), SignUpResponseModel.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}

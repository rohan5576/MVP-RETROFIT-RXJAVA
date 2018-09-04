package com.example.rohanlodhi.job2go.models.response;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class LoginResponseModel {


    /**
     * status : 200
     * msg : [{"id":"2","username":"nik","password":"pooi","created_at":"2018-07-11 19:27:05"}]
     */

    public int status;
    public List<LoginDataModel> msg;

    public static LoginResponseModel objectFromData(String str) {

        return new Gson().fromJson(str, LoginResponseModel.class);
    }

    public static LoginResponseModel objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), LoginResponseModel.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}

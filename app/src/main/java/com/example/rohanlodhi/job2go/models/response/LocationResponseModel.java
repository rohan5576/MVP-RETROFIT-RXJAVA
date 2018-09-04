package com.example.rohanlodhi.job2go.models.response;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class LocationResponseModel {

    /**
     * status : 200
     * msg :
     * data : [{"location":"Banglore"}]
     */

    public int status;
    public String msg;
    public List<LocationDataModel> data;

    public static LocationResponseModel objectFromData(String str) {

        return new Gson().fromJson(str, LocationResponseModel.class);
    }

    public static LocationResponseModel objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), LocationResponseModel.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}

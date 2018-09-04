package com.example.rohanlodhi.job2go.models.response;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class LocationDataModel {
    /**
     * location : Banglore
     */

    public String location;

    public static LocationDataModel objectFromData(String str) {

        return new Gson().fromJson(str, LocationDataModel.class);
    }

    public static LocationDataModel objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), LocationDataModel.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<LocationDataModel> getListWithLabel(List<LocationDataModel> locationDataModels) {
        LocationDataModel locationDataModel = new LocationDataModel();
        locationDataModel.location = "Select Job Location";

        locationDataModels.add(0, locationDataModel);

        return locationDataModels;
    }

    @Override
    public String toString() {
        return location;
    }
}

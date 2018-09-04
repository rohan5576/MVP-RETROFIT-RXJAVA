package com.example.rohanlodhi.job2go.models.response;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JobTitleResponseModel {

    /**
     * status : 200
     * msg :
     * data : [{"id":"1","job_title":"PHP Developer"},{"id":"2","job_title":"Android Developer"}]
     */

    public int status;
    public String msg;
    public List<JobTitleDataModel> data;

    public static JobTitleResponseModel objectFromData(String str) {

        return new Gson().fromJson(str, JobTitleResponseModel.class);
    }

    public static JobTitleResponseModel objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), JobTitleResponseModel.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}

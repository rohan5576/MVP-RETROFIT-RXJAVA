package com.example.rohanlodhi.job2go.models.response;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JobTitleDataModel {
    /**
     * id : 1
     * job_title : PHP Developer
     */

    public String id;
    public String job_title;

    public static JobTitleDataModel objectFromData(String str) {

        return new Gson().fromJson(str, JobTitleDataModel.class);
    }

    public static JobTitleDataModel objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), JobTitleDataModel.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<JobTitleDataModel> getListWithLabel(List<JobTitleDataModel> jobTitleDataModels) {
        JobTitleDataModel jobTitleDataModel = new JobTitleDataModel();
        jobTitleDataModel.job_title = "Select Job Title";

        jobTitleDataModels.add(0, jobTitleDataModel);

        return jobTitleDataModels;
    }

    @Override
    public String toString() {
        return job_title;
    }
}

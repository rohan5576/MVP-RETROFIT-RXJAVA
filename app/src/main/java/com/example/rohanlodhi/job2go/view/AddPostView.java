package com.example.rohanlodhi.job2go.view;

import com.example.rohanlodhi.job2go.models.request.LoginRequestModel;
import com.example.rohanlodhi.job2go.models.response.JobTitleResponseModel;
import com.example.rohanlodhi.job2go.models.response.LocationResponseModel;
import com.example.rohanlodhi.job2go.models.response.LoginResponseModel;


public interface AddPostView extends BaseView {


    void JobTitleResponseModel(JobTitleResponseModel s);

    void LocationResponseModel(LocationResponseModel s);

    int getTitleId();

    int getUserId();


}

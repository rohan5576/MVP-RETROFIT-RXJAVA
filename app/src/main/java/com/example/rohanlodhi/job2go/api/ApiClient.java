package com.example.rohanlodhi.job2go.api;

import com.example.rohanlodhi.job2go.models.response.JobTitleResponseModel;
import com.example.rohanlodhi.job2go.models.response.LocationResponseModel;
import com.example.rohanlodhi.job2go.models.response.LoginResponseModel;
import com.example.rohanlodhi.job2go.models.response.SignUpResponseModel;
import com.example.rohanlodhi.job2go.ui.Constants;


import retrofit.RestAdapter;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

public class ApiClient {
    private ApiService mApiService;

    public ApiClient() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.BASE_URL_API)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        mApiService = restAdapter.create(ApiService.class);
    }

    public ApiService getApi() {
        return mApiService;
    }

    public interface ApiService {

        @FormUrlEncoded
        @POST("/User/login")
        Observable<LoginResponseModel>
        login(@Field("username") String request,@Field ("password")String  password);

        @FormUrlEncoded
        @POST("/User/signUp")
        Observable<SignUpResponseModel>
        signUp(@Field("username") String request,@Field ("password")String  password,@Field ("verify_password")String verifypassword);

        @FormUrlEncoded
        @POST("/Job/getJobTitleListn")
        Observable<JobTitleResponseModel>
        getJobTitle(@Field("id") int request);


        @FormUrlEncoded
        @POST("/Job/getJobLocList")
        Observable<LocationResponseModel>
        getJobLocation(@Field("id") int request);



    }


}

package com.example.rohanlodhi.job2go.presenter;

import com.example.rohanlodhi.job2go.api.ApiClient;
import com.example.rohanlodhi.job2go.api.manager.APIManager;
import com.example.rohanlodhi.job2go.models.response.JobTitleResponseModel;
import com.example.rohanlodhi.job2go.models.response.LocationResponseModel;
import com.example.rohanlodhi.job2go.models.response.LoginResponseModel;
import com.example.rohanlodhi.job2go.view.AddPostView;
import com.example.rohanlodhi.job2go.view.PostListView;


public class AddPostPresenter {

    private AddPostView mView;
    private ApiClient mApiClient;

    public AddPostPresenter(AddPostView view, ApiClient client) {
        mView = view;
        mApiClient = client;
        mView.showProgress();
    }

    public void getJobTitleList() {
        new APIManager(mApiClient).onJobTitle(mView.getTitleId()).doOnError(throwable -> mView.hideProgress()).subscribe((JobTitleResponseModel s) -> {
            mView.JobTitleResponseModel(s);
            mView.hideProgress();
        });
    }

    public void getJobLocationList() {
        new APIManager(mApiClient).onJobLocation(mView.getUserId()).doOnError(throwable -> mView.hideProgress()).subscribe((LocationResponseModel s) -> {
            mView.LocationResponseModel(s);
            mView.hideProgress();
        });
    }
}

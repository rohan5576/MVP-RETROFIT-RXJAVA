package com.example.rohanlodhi.job2go.presenter;

import com.example.rohanlodhi.job2go.api.ApiClient;
import com.example.rohanlodhi.job2go.api.manager.APIManager;
import com.example.rohanlodhi.job2go.view.LoginView;
import com.example.rohanlodhi.job2go.view.PostListView;


public class PostListPresenter {

    private PostListView mView;
    private ApiClient mApiClient;

    public PostListPresenter(PostListView view, ApiClient client) {
        mView = view;
        mApiClient = client;
        mView.showProgress();
    }

//    public void login() {
//        new APIManager(mApiClient).onLoginRequest(mView.getLoginRequestModel().username,mView.getLoginRequestModel().password).doOnError(throwable -> mView.hideProgress()).subscribe(s -> {
//            mView.onLoginSuccess(s);
//            mView.hideProgress();
//        });
//    }


}

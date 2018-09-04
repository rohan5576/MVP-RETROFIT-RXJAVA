package com.example.rohanlodhi.job2go.presenter;

import com.example.rohanlodhi.job2go.api.ApiClient;
import com.example.rohanlodhi.job2go.api.manager.APIManager;
import com.example.rohanlodhi.job2go.view.LoginView;



public class LoginPresenter {

    private LoginView mView;
    private ApiClient mApiClient;

    public LoginPresenter(LoginView view, ApiClient client) {
        mView = view;
        mApiClient = client;
        mView.showProgress();
    }

    public void login() {
        new APIManager(mApiClient).onLoginRequest(mView.getLoginRequestModel().username,mView.getLoginRequestModel().password).doOnError(throwable -> mView.hideProgress()).subscribe(s -> {
            mView.onLoginSuccess(s);
            mView.hideProgress();
        });
    }


}

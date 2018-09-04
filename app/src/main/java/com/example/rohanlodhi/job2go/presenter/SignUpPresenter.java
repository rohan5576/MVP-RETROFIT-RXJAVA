package com.example.rohanlodhi.job2go.presenter;

import com.example.rohanlodhi.job2go.api.ApiClient;
import com.example.rohanlodhi.job2go.api.manager.APIManager;
import com.example.rohanlodhi.job2go.view.LoginView;
import com.example.rohanlodhi.job2go.view.SignUpView;


public class SignUpPresenter {

    private SignUpView mView;
    private ApiClient mApiClient;

    public SignUpPresenter(SignUpView view, ApiClient client) {
        mView = view;
        mApiClient = client;
        mView.showProgress();
    }

    public void SignUp() {
        new APIManager(mApiClient).onSignUpRequest(mView.getSignUpRequestModel().username,mView.getSignUpRequestModel().password,
                mView.getSignUpRequestModel().verify_password).doOnError(throwable -> mView.hideProgress()).subscribe(s -> {
            mView.onSignUpSuccess(s);
            mView.hideProgress();
        });
    }


}

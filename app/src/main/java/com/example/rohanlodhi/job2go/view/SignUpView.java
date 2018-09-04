package com.example.rohanlodhi.job2go.view;

import com.example.rohanlodhi.job2go.models.request.LoginRequestModel;
import com.example.rohanlodhi.job2go.models.request.SignUpRequestModel;
import com.example.rohanlodhi.job2go.models.response.LoginResponseModel;
import com.example.rohanlodhi.job2go.models.response.SignUpResponseModel;


public interface SignUpView extends BaseView {


    void onSignUpSuccess(SignUpResponseModel s);


     SignUpRequestModel getSignUpRequestModel();

}

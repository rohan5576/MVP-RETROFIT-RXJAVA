package com.example.rohanlodhi.job2go.view;

import com.example.rohanlodhi.job2go.models.request.LoginRequestModel;
import com.example.rohanlodhi.job2go.models.response.LoginResponseModel;



public interface LoginView extends BaseView {


    void onLoginSuccess(LoginResponseModel s);


     LoginRequestModel  getLoginRequestModel();

}

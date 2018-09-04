package com.example.rohanlodhi.job2go.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.rohanlodhi.job2go.R;
import com.example.rohanlodhi.job2go.api.ApiClient;
import com.example.rohanlodhi.job2go.models.request.LoginRequestModel;
import com.example.rohanlodhi.job2go.models.response.LoginDataModel;
import com.example.rohanlodhi.job2go.models.response.LoginResponseModel;
import com.example.rohanlodhi.job2go.presenter.LoginPresenter;
import com.example.rohanlodhi.job2go.ui.AppPreferences;
import com.example.rohanlodhi.job2go.ui.Constants;
import com.example.rohanlodhi.job2go.ui.ValidationUtil;
import com.example.rohanlodhi.job2go.view.LoginView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.edittext_email)
    EditText mEditTextEmail;
    @BindView(R.id.edittext_password)
    EditText mEditTextPassword;

    private String etEmail;
    @BindViews({R.id.textview_login, R.id.textview_sign_up})
    List<TextView> mtextviews;


    static final ButterKnife.Action<View> DISABLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(View view, int index) {
            view.setEnabled(false);
        }
    };
    static final ButterKnife.Setter<View, Boolean> ENABLED = new ButterKnife.Setter<View, Boolean>() {
        @Override
        public void set(View view, Boolean value, int index) {
            view.setEnabled(value);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ButterKnife.apply(mtextviews, DISABLE);
        ButterKnife.apply(mtextviews, ENABLED, true);
    }

    @OnClick({R.id.textview_login, R.id.textview_sign_up})
    public void setViewOnClickEvent(View view) {
        switch (view.getId()) {
            case R.id.textview_login:
                if (!isNetworkAvailable()) {
                    Toast.makeText(this,getResources().getString(R.string.INTERNET_LOST) , Toast.LENGTH_SHORT).show();
                    return;
                }

                if (ValidationUtil.isValidEmail(mEditTextEmail) && ValidationUtil.isValidatePassword(mEditTextPassword)) {
                    OnLoginSuccessful();
                }

                break;
            case R.id.textview_sign_up:
                Intent i1 = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i1);
                break;

        }
    }

    @Override
    public void onLoginSuccess(LoginResponseModel loginResponseModel) {
             if(loginResponseModel.status== Constants.STATUS_200){
                 if(loginResponseModel.msg!=null){
                     AppPreferences.getInstance(this).putInt(Constants.ID,loginResponseModel.msg.get(0).id);


                     startActivity(new Intent(LoginActivity.this, NavigationActivity.class));
                     finish();
                 }
             }
    }

    public  void OnLoginSuccessful(){
        LoginPresenter loginPresenter = new LoginPresenter(this, new ApiClient());
        loginPresenter.login();
    }

    @Override
    public LoginRequestModel getLoginRequestModel() {
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.username =mEditTextEmail.getText().toString() ;
        loginRequestModel.password = mEditTextPassword.getText().toString();
        return loginRequestModel;
    }
}


package com.example.rohanlodhi.job2go.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohanlodhi.job2go.R;
import com.example.rohanlodhi.job2go.api.ApiClient;
import com.example.rohanlodhi.job2go.models.request.LoginRequestModel;
import com.example.rohanlodhi.job2go.models.request.SignUpRequestModel;
import com.example.rohanlodhi.job2go.models.response.SignUpResponseModel;
import com.example.rohanlodhi.job2go.presenter.LoginPresenter;
import com.example.rohanlodhi.job2go.presenter.SignUpPresenter;
import com.example.rohanlodhi.job2go.ui.AppPreferences;
import com.example.rohanlodhi.job2go.ui.Constants;
import com.example.rohanlodhi.job2go.ui.ValidationUtil;
import com.example.rohanlodhi.job2go.view.SignUpView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity implements SignUpView{

    @BindView(R.id.btn_sign_up)
    Button tvSignUp;
    @BindView(R.id.et_verify_password)
    EditText etVerifyPassword;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.et_email)
    EditText etEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.btn_sign_up)
    public void onSignUp(){
        if (!isNetworkAvailable()) {
            Toast.makeText(this,getResources().getString(R.string.INTERNET_LOST) , Toast.LENGTH_SHORT).show();
            return;
        }

        if (ValidationUtil.isValidEmail(etEmail) && ValidationUtil.isValidatePassword(etPassword)
                &&ValidationUtil.isValidatePassword(etPassword)) {
          onSignUpSuccessful();
        }
    }


    public  void onSignUpSuccessful(){
        SignUpPresenter signUpPresenter = new SignUpPresenter(this, new ApiClient());
        signUpPresenter.SignUp();

    }


    @Override
    public void onSignUpSuccess(SignUpResponseModel signUpResponseModel) {
        if(signUpResponseModel.status== Constants.STATUS_200){
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            finish();
        }
    }

    @Override
    public SignUpRequestModel getSignUpRequestModel() {
        SignUpRequestModel signUpRequestModel = new SignUpRequestModel();
        signUpRequestModel.username = etEmail.getText().toString();
        signUpRequestModel.password = etPassword.getText().toString();
        signUpRequestModel.verify_password =etVerifyPassword.getText().toString();

        return signUpRequestModel;
    }
}

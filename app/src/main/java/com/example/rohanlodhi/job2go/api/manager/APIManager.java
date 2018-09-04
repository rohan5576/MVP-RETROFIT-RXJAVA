package com.example.rohanlodhi.job2go.api.manager;

import android.util.Log;

import com.example.rohanlodhi.job2go.api.ApiClient;
import com.example.rohanlodhi.job2go.models.response.JobTitleResponseModel;
import com.example.rohanlodhi.job2go.models.response.LocationResponseModel;
import com.example.rohanlodhi.job2go.models.response.LoginResponseModel;
import com.example.rohanlodhi.job2go.models.response.SignUpResponseModel;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rohanlodhi on 3/29/18.
 */

public class APIManager {
    private ApiClient mApiClient;

    public APIManager(ApiClient client) {
        mApiClient = client;
    }

    public Observable<LoginResponseModel> onLoginRequest(String username,String password) {
        return mApiClient.getApi().login(username,password).doOnNext(user -> {
        }).doOnCompleted(() -> Log.d("called getAilments", "found response"))
                .doOnError(Throwable::printStackTrace)
                .onErrorReturn(throwable -> null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<SignUpResponseModel> onSignUpRequest(String username, String password,String verifyPassword) {
        return mApiClient.getApi().signUp(username,password,verifyPassword).doOnNext(user -> {
        }).doOnCompleted(() -> Log.d("called getAilments", "found response"))
                .doOnError(Throwable::printStackTrace)
                .onErrorReturn(throwable -> null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public Observable<JobTitleResponseModel> onJobTitle(int id) {
        return mApiClient.getApi().getJobTitle(id).doOnNext(user -> {
        }).doOnCompleted(() -> Log.d("called getAilments", "found response"))
                .doOnError(Throwable::printStackTrace)
                .onErrorReturn(throwable -> null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public Observable<LocationResponseModel> onJobLocation(int id) {
        return mApiClient.getApi().getJobLocation(id).doOnNext(user -> {
        }).doOnCompleted(() -> Log.d("called getAilments", "found response"))
                .doOnError(Throwable::printStackTrace)
                .onErrorReturn(throwable -> null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

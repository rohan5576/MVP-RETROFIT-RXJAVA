package com.example.rohanlodhi.job2go.ui.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.rohanlodhi.job2go.R;
import com.example.rohanlodhi.job2go.ui.LoadingBridge;
import com.example.rohanlodhi.job2go.ui.fragment.ProgressDialogFragment;


/**
 * Created by Sachin on 21/8/17.
 */

public class BaseActivity extends AppCompatActivity implements LoadingBridge {

    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.app_name), 0); // 0 - for private mode

    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    void initializeToolbarUpEnabled() {
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    void initializeToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar));
    }

    @Override
    public synchronized void showProgress() {
        ProgressDialogFragment.show(getSupportFragmentManager());
    }

    @Override
    public synchronized void hideProgress() {
        ProgressDialogFragment.hide(getSupportFragmentManager());
    }

    public synchronized void showDummyProgress(int second) {
        showProgress();
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            hideProgress();
            performAction();
        }, second * 1000);
    }

    public synchronized void performAction() {

    }
}

package com.example.rohanlodhi.job2go.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;


import com.example.rohanlodhi.job2go.R;
import com.example.rohanlodhi.job2go.ui.AppPreferences;
import com.example.rohanlodhi.job2go.ui.Constants;


public class SplashActivity extends AppCompatActivity {

    private static final int DURATION = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        new Handler().postDelayed(() -> {
            if (AppPreferences.getInstance(SplashActivity.this).containsKey(Constants.ID)) {
                startActivity(new Intent(SplashActivity.this, NavigationActivity.class));
                finish();
            } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }

        }, DURATION);
    }

    }

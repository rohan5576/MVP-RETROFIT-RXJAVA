package com.example.rohanlodhi.job2go.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rohanlodhi.job2go.R;

import butterknife.ButterKnife;

public class PostDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);
        ButterKnife.bind(this);
    }
}

package com.example.rohanlodhi.job2go.ui.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohanlodhi.job2go.R;
import com.example.rohanlodhi.job2go.adapters.PostListAdapter;
import com.example.rohanlodhi.job2go.api.ApiClient;
import com.example.rohanlodhi.job2go.listerners.OnItemClickListener;
import com.example.rohanlodhi.job2go.presenter.PostListPresenter;
import com.example.rohanlodhi.job2go.ui.AppPreferences;
import com.example.rohanlodhi.job2go.ui.Constants;
import com.example.rohanlodhi.job2go.ui.main.MainActivity;
import com.example.rohanlodhi.job2go.view.PostListView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.LinearLayout.VERTICAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobListingFragment extends Fragment implements OnItemClickListener ,PostListView {


    @BindView(R.id.rv_my_notification)
    RecyclerView rvPostRecycler;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    PostListAdapter postListAdapter;

    private Context context;

    public JobListingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job_listing, container, false);
        ButterKnife.bind(this, view);
        context = container.getContext();
        initUi();

        return  view;
    }
    private void initUi() {
        initRecyclerView();


        swipeRefreshLayout.setOnRefreshListener(() -> getNotification());
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.white);
    }
    private void getNotification() {
        swipeRefreshLayout.setRefreshing(true);
        if (((MainActivity) Objects.requireNonNull(getActivity())).isNetworkAvailable()) {
//            PostListPresenter notificationPresenter = new PostListPresenter(this, new ApiClient());
//            notificationPresenter.getNotification();
        } else {
            Toast.makeText(context,getResources().getString(R.string.INTERNET_LOST) , Toast.LENGTH_SHORT).show();

        }
    }

//    public String getNotificationRequest() {
//        return AppPreferences.getInstance(context).getString(AppPreferences.USERNAME, "");
//    }
//
//    public void getNotificationResponse(NotificationResponseModel notificationResponseModel) {
//        if (notificationResponseModel != null && notificationResponseModel.results.outcome.equals(Constants.SUCCESS)) {
//            tvAlt.setVisibility(notificationResponseModel.results.data.size() == 0 ? View.VISIBLE : View.GONE);
//            myNotificationListAdapter.setData(notificationResponseModel.results.data);
//        }
//        swipeRefreshLayout.setRefreshing(false);
//    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, VERTICAL, false);
        rvPostRecycler.setLayoutManager(layoutManager);
        postListAdapter = new PostListAdapter(context, this);
        rvPostRecycler.setAdapter(postListAdapter);

    }

    @Override
    public void onClick(int position, View pView) {

    }

    @Override
    public void onResume() {
        super.onResume();
        getNotification();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}

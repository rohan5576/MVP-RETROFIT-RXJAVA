package com.example.rohanlodhi.job2go.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohanlodhi.job2go.R;
import com.example.rohanlodhi.job2go.adapters.SpinnerArrayAdapter;
import com.example.rohanlodhi.job2go.api.ApiClient;
import com.example.rohanlodhi.job2go.models.response.JobTitleDataModel;
import com.example.rohanlodhi.job2go.models.response.JobTitleResponseModel;
import com.example.rohanlodhi.job2go.models.response.LocationDataModel;
import com.example.rohanlodhi.job2go.models.response.LocationResponseModel;
import com.example.rohanlodhi.job2go.presenter.AddPostPresenter;
import com.example.rohanlodhi.job2go.ui.Constants;
import com.example.rohanlodhi.job2go.ui.main.MainActivity;
import com.example.rohanlodhi.job2go.view.AddPostView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddJobPostFragment extends Fragment implements AddPostView {

    @BindView(R.id.spin_jobtitle)
    Spinner spinJobTitle;
    @BindView(R.id.spin_location) Spinner spinLocation;
    @BindView(R.id.et_company_name) EditText et_company_name;
    @BindView(R.id.et_experience) EditText et_experience;
    @BindView(R.id.et_mobile) EditText et_mobile;
    @BindView(R.id.et_email) EditText et_email;
    @BindView(R.id.et_website) EditText et_website;
    @BindView(R.id.et_description) EditText et_description;
    @BindView(R.id.tv_post) TextView tv_post;



    public AddJobPostFragment() {
        // Required empty public constructor
    }

    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_job_post, container, false);
        ButterKnife.bind(this, view);
        context = container.getContext();
        initUi();

        return  view;
    }

    public  void initUi(){
//        inflateSpinLocation();
        inflateSpinJobTitle(new ArrayList<>());
        spinJobTitle.setClickable(false);


        if (((MainActivity) Objects.requireNonNull(getActivity())).isNetworkAvailable()) {
            getJobTitleList();
        } else {
            Toast.makeText(context,getResources().getString(R.string.INTERNET_LOST) , Toast.LENGTH_SHORT).show();

        }
    }

    public void getJobTitleList() {
        AddPostPresenter addPostPresenter = new AddPostPresenter(AddJobPostFragment.this, new ApiClient());
        addPostPresenter.getJobTitleList();
    }

    public void getJobLocationList() {
        AddPostPresenter addPostPresenter = new AddPostPresenter(AddJobPostFragment.this, new ApiClient());
        addPostPresenter.getJobLocationList();
    }

    private void inflateSpinJobTitle(List<JobTitleDataModel> data) {
        if (data == null)
            return;
        SpinnerArrayAdapter<JobTitleDataModel> adapter = new SpinnerArrayAdapter<JobTitleDataModel>(context, R.layout.item_spinner, JobTitleDataModel.getListWithLabel(data));
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinJobTitle.setAdapter(adapter);
    }

    private void inflateSpinJobLocation(List<LocationDataModel> data) {
        if (data == null)
            return;
        SpinnerArrayAdapter<LocationDataModel> adapter = new SpinnerArrayAdapter<LocationDataModel>(context, R.layout.item_spinner, LocationDataModel.getListWithLabel(data));
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinLocation.setAdapter(adapter);
    }



    @OnItemSelected(R.id.spin_jobtitle)
    public void onJobTitleSelected() {
        getJobLocationList();
    }


    @Override
    public void JobTitleResponseModel(JobTitleResponseModel jobTitleResponseModel) {
        if (jobTitleResponseModel != null && jobTitleResponseModel.status== Constants.STATUS_200) {
            inflateSpinJobTitle(jobTitleResponseModel.data);
            inflateSpinJobLocation(new ArrayList<>());
        } else {
            Toast.makeText(context,getResources().getString(R.string.something_wrong_error) , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void LocationResponseModel(LocationResponseModel locationResponseModel) {
        if (locationResponseModel != null && locationResponseModel.status== Constants.STATUS_200) {
            inflateSpinJobLocation(locationResponseModel.data);
        } else {
            Toast.makeText(context,getResources().getString(R.string.something_wrong_error) , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getTitleId() {
        return 0;
    }

    @Override
    public int getUserId() {
        return 0;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

//    private void inflateSpinWard() {
//        if (wardDataModels == null)
//            return;
//        SpinnerArrayAdapter<WardDataModel> adapter = new SpinnerArrayAdapter<>(context, in.net.indies.R.layout.item_spinner, WardDataModel.getListWithLabel(wardDataModels));
//        adapter.setDropDownViewResource(in.net.indies.R.layout.spinner_dropdown_item);
//        spinWard.setAdapter(adapter);
//    }
}

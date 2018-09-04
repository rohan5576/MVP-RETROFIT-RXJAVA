package com.example.rohanlodhi.job2go.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rohanlodhi.job2go.R;
import com.example.rohanlodhi.job2go.listerners.OnItemClickListener;
import com.example.rohanlodhi.job2go.models.response.PostResponseModel;

import java.util.List;

import butterknife.ButterKnife;


public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.ViewHolder> {

    private List<PostResponseModel> postResponseModels;

    public PostListAdapter(Context context, OnItemClickListener pOnItemClickListener) {
        super();
        OnItemClickListener mOnItemClickListener = pOnItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_jobs_items, viewGroup, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        NotificationModel notificationModel = this.notificationModelList.get(i);
//        viewHolder.tvDescription.setText(notificationModel.description);
//        viewHolder.tvId.setText(notificationModel.title);
    }

    @Override
    public int getItemCount() {
        return postResponseModels == null ? 0 : postResponseModels.size();
    }

    public void setData(List<PostResponseModel> postResponseModels) {
        this.postResponseModels = postResponseModels;
        notifyDataSetChanged();
    }

    public PostResponseModel getItem(int position) {
        return postResponseModels.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

//        @BindView(R.id.tv_description) TextView tvDescription;
//        @BindView(R.id.tv_id) TextView tvId;
//        @BindView(R.id.tv_posted_on) TextView tvPostedOn;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
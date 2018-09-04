package com.example.rohanlodhi.job2go.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.rohanlodhi.job2go.R;

import java.util.List;



/**
 * Created by spoton on 29/11/17.
 */

public class SpinnerArrayAdapter<T> extends ArrayAdapter<T> {

    public SpinnerArrayAdapter(@NonNull Context context, int resource, @NonNull T[] objects) {
        super(context, resource, objects);
    }

    public SpinnerArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<T> objects) {
        super(context, resource, 0, objects);
    }

    @Override
    public boolean isEnabled(int position) {
        return position != 0;
    }

    @SuppressLint("NewApi")
    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);
        TextView tv = (TextView) view;
        if (position == 0) {
            // Set the hint text color gray
            tv.setTextColor(Color.WHITE);
            tv.setTypeface(null, Typeface.BOLD);
            tv.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.drop_down, 0);
        } else {
            tv.setTextColor(Color.WHITE);
            tv.setTypeface(null, Typeface.NORMAL);
            tv.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        }
        return view;
    }
}

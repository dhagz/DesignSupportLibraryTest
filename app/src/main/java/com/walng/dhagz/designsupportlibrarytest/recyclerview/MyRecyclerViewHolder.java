package com.walng.dhagz.designsupportlibrarytest.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.walng.dhagz.designsupportlibrarytest.R;

/**
 * @author Dhagz
 * @since 2015-06-09
 */
public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public MyRecyclerViewHolder(View view) {
        super(view);
        textView = (TextView) view.findViewById(R.id.textView);
    }
}

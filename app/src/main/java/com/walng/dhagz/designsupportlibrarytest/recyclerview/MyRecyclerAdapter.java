package com.walng.dhagz.designsupportlibrarytest.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.walng.dhagz.designsupportlibrarytest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dhagz
 * @since 2015-06-09
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {
    private List<MyItem> mItem = new ArrayList<MyItem>();

    public MyRecyclerAdapter(Context context) {
        //
    }

    public void updateList(List<MyItem> items) {
        this.mItem = items;
        notifyDataSetChanged();
    }

    public void addItem(int position, MyItem item) {
        mItem.add(position, item);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mItem.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.recycler_item, viewGroup, false);
        return new MyRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewHolder myRecyclerViewHolder, int position) {
        myRecyclerViewHolder.textView.setText(mItem.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return this.mItem.size();
    }
}

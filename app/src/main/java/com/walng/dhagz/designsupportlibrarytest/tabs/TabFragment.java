package com.walng.dhagz.designsupportlibrarytest.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.walng.dhagz.designsupportlibrarytest.R;
import com.walng.dhagz.designsupportlibrarytest.recyclerview.MyItem;
import com.walng.dhagz.designsupportlibrarytest.recyclerview.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dhagz
 * @since 2015-06-28
 */
public class TabFragment extends Fragment {

    private MyRecyclerAdapter mAdapter;
    private RecyclerView mRecyclerView;

    public TabFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        // INITIALIZE RECYCLER VIEW
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        // If the size of views will not change as the data changes.
        mRecyclerView.setHasFixedSize(true);
        // setting the layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        // setting the adapter
        mAdapter = new MyRecyclerAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        // populate the list
        String[] listItems = getResources().getStringArray(R.array.items_list);
        for (int a = 0; a < listItems.length; a++) {
            mAdapter.addItem(a, new MyItem(listItems[a]));
        }
        return view;
    }
}

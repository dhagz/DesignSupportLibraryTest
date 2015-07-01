package com.walng.dhagz.designsupportlibrarytest.coordlayout.appbar;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.walng.dhagz.designsupportlibrarytest.R;
import com.walng.dhagz.designsupportlibrarytest.recyclerview.MyItem;
import com.walng.dhagz.designsupportlibrarytest.recyclerview.MyRecyclerAdapter;

public class CoordLayoutAppBarImgActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbar;

    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coord_layout_app_bar_img);
        initViews();
    }

    private void initViews() {
        // INITIALIZE TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // INITIALIZE COLLAPSING TOOLBAR
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collpasingToolbar);
        mCollapsingToolbar.setTitle(this.getTitle());

        // INITIALIZE RECYCLER VIEW
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // If the size of views will not change as the data changes.
        mRecyclerView.setHasFixedSize(true);
        // setting the layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // setting the adapter
        mAdapter = new MyRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        // populate the list
        String[] listItems = getResources().getStringArray(R.array.items_list);
        for (int a = 0; a < listItems.length; a++) {
            mAdapter.addItem(a, new MyItem(listItems[a]));
        }

        // INITIALIZE FLOATING ACTION BUTTON
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mRecyclerView, R.string.snackbar_alert_message, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

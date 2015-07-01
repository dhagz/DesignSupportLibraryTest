package com.walng.dhagz.designsupportlibrarytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.walng.dhagz.designsupportlibrarytest.recyclerview.MyItem;
import com.walng.dhagz.designsupportlibrarytest.recyclerview.MyRecyclerAdapter;


public class MyItemInputFieldsActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_item_input_fields);
        initViews();
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            // enable ActionBar app icon to behave as action to toggle nav drawer
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        if (mRecyclerView != null && mAdapter != null) {
            populateList(mAdapter);
        }
    }

    private void initViews() {
        // INITIALIZE TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

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
    }

    private void populateList(MyRecyclerAdapter adapter) {
        String[] listItems = new String[]{
                "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10",
                "Item 11", "Item 12", "Item 13", "Item 14", "Item 15", "Item 16", "Item 17", "Item 18", "Item 19", "Item 20",
                "Item 21", "Item 22", "Item 23", "Item 24", "Item 25", "Item 26", "Item 27", "Item 28", "Item 29", "Item 30"
        };
        for (int a = 0; a < listItems.length; a++) {
            adapter.addItem(a, new MyItem(listItems[a]));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_item_input_fields, menu);
        return true;
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
        } else if (id == R.id.action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.walng.dhagz.designsupportlibrarytest.recyclerview;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.walng.dhagz.designsupportlibrarytest.MyItemInputFieldsActivity;
import com.walng.dhagz.designsupportlibrarytest.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initViews();
    }

    private void initViews() {
        // INITIALIZE TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recycler_view, menu);
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
        } else if (id == R.id.action_item_add_top) {
            mAdapter.addItem(0, new MyItem(getString(R.string.item_new)));
            Toast.makeText(this, R.string.item_add_top, Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.action_item_add_bottom) {
            mAdapter.addItem(mAdapter.getItemCount(), new MyItem(getString(R.string.item_new)));
            Toast.makeText(this, R.string.item_add_bottom, Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.action_item_remove_top) {
            mAdapter.removeItem(0);
            Toast.makeText(this, R.string.item_remove_top, Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.action_item_remove_bottom) {
            mAdapter.removeItem(mAdapter.getItemCount() - 1);
            Toast.makeText(this, R.string.item_remove_bottom, Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

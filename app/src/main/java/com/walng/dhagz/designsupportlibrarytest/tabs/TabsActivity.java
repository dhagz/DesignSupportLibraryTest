package com.walng.dhagz.designsupportlibrarytest.tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.walng.dhagz.designsupportlibrarytest.R;
import com.walng.dhagz.designsupportlibrarytest.recyclerview.MyRecyclerAdapter;

/**
 * Source: http://blog.grafixartist.com/material-design-tabs-with-android-design-support-library/
 * @since 2015-06-28
 */
public class TabsActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        initViews();
    }

    private void initViews() {
        // INITIALIZE TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // INITIALIZE VIEW PAGER
        mViewPager = (ViewPager) findViewById(R.id.pager);
//        setupViewPager(mViewPager);
        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new TabFragment(), getString(R.string.tab_name_1));
        adapter.addFrag(new TabFragment(), getString(R.string.tab_name_2));
        adapter.addFrag(new TabFragment(), getString(R.string.tab_name_3));
        adapter.addFrag(new TabFragment(), getString(R.string.tab_name_4));
        adapter.addFrag(new TabFragment(), getString(R.string.tab_name_5));
        mViewPager.setAdapter(adapter);

        // INITIALIZE TAB LAYOUT
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
//        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_name_1));
//        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_name_2));
//        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_name_3));
//        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_name_4));
//        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_name_5));
        mTabLayout.setupWithViewPager(mViewPager);
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

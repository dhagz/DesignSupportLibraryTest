package com.walng.dhagz.designsupportlibrarytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.walng.dhagz.designsupportlibrarytest.cardview.CardViewActivity;
import com.walng.dhagz.designsupportlibrarytest.coordlayout.appbar.CoordLayoutAppBarActivity;
import com.walng.dhagz.designsupportlibrarytest.coordlayout.appbar.CoordLayoutAppBarImgActivity;
import com.walng.dhagz.designsupportlibrarytest.coordlayout.fab.CoordLayoutFabActivity;
import com.walng.dhagz.designsupportlibrarytest.floatingactionbutton.FloatingActionButtonActivity;
import com.walng.dhagz.designsupportlibrarytest.floatinglabels.FloatingLabelsActivity;
import com.walng.dhagz.designsupportlibrarytest.navigationview.NavigationViewActivity;
import com.walng.dhagz.designsupportlibrarytest.recyclerview.RecyclerViewActivity;
import com.walng.dhagz.designsupportlibrarytest.snackbar.SnackbarActivity;
import com.walng.dhagz.designsupportlibrarytest.tabs.TabsActivity;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Toolbar mToolbar;
    private ListView mListView;
    private ArrayAdapter<String> mItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        // INITIALIZE TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        // set the toolbar as the actionbar
        setSupportActionBar(mToolbar);
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // INITIALIZE LISTVIEW
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setOnItemClickListener(this);
        String[] items = getResources().getStringArray(R.array.main_menu);
        mItemsAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        mListView.setAdapter(mItemsAdapter);
    }

    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = mItemsAdapter.getItem(position);
        if (item.equals(getString(R.string.main_navigation_view))) {
            startActivity(new Intent(this, NavigationViewActivity.class));
        } else if (item.equals(getString(R.string.main_floating_labels))) {
            startActivity(new Intent(this, FloatingLabelsActivity.class));
        } else if (item.equals(getString(R.string.main_floating_action_button))) {
            startActivity(new Intent(this, FloatingActionButtonActivity.class));
        } else if (item.equals(getString(R.string.main_snackbar))) {
            startActivity(new Intent(this, SnackbarActivity.class));
        } else if (item.equals(getString(R.string.main_card_view))) {
            startActivity(new Intent(this, CardViewActivity.class));
        } else if (item.equals(getString(R.string.main_recycler_view))) {
            startActivity(new Intent(this, RecyclerViewActivity.class));
        } else if (item.equals(getString(R.string.main_coord_layout_fab))) {
            startActivity(new Intent(this, CoordLayoutFabActivity.class));
        } else if (item.equals(getString(R.string.main_coord_layout_appbar))) {
            startActivity(new Intent(this, CoordLayoutAppBarActivity.class));
        } else if (item.equals(getString(R.string.main_collapsing_toolbars_parallax_img))) {
            startActivity(new Intent(this, CoordLayoutAppBarImgActivity.class));
        } else if (item.equals(getString(R.string.main_tabs_view_pager))) {
            startActivity(new Intent(this, TabsActivity.class));
        }
    }
}

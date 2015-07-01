package com.walng.dhagz.designsupportlibrarytest.snackbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.walng.dhagz.designsupportlibrarytest.R;

public class SnackbarActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private View mParentLayout;
    private Button mDisplaySnackbarShort;
    private Button mDisplaySnackbarLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        // INITIALIZE TOOLBAR
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        // set the toolbar as the actionbar
        setSupportActionBar(mToolbar);
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // INITIALIZE PARENT LAYOUT
        mParentLayout = findViewById(R.id.parentLayout);

        // INITIALIZE DISPLAY SNACKBAR BUTTON (SHORT)
        mDisplaySnackbarShort = (Button) findViewById(R.id.showSnackbarLengthShort);
        mDisplaySnackbarShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mParentLayout, R.string.snackbar_messge, Snackbar.LENGTH_SHORT)
                        .setAction(R.string.snackbar_button_text, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                displayAlertMessage();
                            }
                        }).show();
            }
        });

        // INITIALIZE DISPLAY SNACKBAR BUTTON (LONG)
        mDisplaySnackbarLong = (Button) findViewById(R.id.showSnackbarLengthLong);
        mDisplaySnackbarLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mParentLayout, R.string.snackbar_messge, Snackbar.LENGTH_LONG)
                        .setAction(R.string.snackbar_button_text, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                displayAlertMessage();
                            }
                        }).show();
            }
        });
    }

    private void displayAlertMessage() {
        new AlertDialog.Builder(SnackbarActivity.this)
                .setMessage(R.string.snackbar_alert_message)
                .setPositiveButton(R.string.snackbar_alert_positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                })
                .setNegativeButton(R.string.snackbar_alert_negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                })
                .setNeutralButton(R.string.snackbar_alert_neutral, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                })
                .create()
                .show();
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

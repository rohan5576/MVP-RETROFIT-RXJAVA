package com.example.rohanlodhi.job2go.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.rohanlodhi.job2go.R;
import com.example.rohanlodhi.job2go.ui.fragment.AddJobPostFragment;
import com.example.rohanlodhi.job2go.ui.fragment.JobListingFragment;

public class NavigationActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Fragment mSelectedFragment;
    private FragmentManager mFragementManager;
    private String mTitle;
    private FragmentTransaction mFragementTransaction;
    private NavigationView mNavigationView;
    private Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mFragementManager = getSupportFragmentManager();
        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        initScreen();
    }

    public void initScreen() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mtoolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(new SelectedNavigationItemListener());
        initFragement();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*
     * NAVIGATION VIEW CLICK LISTENER
     * */
    private class SelectedNavigationItemListener implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            try {
                menuItem.setChecked(true);
                mTitle = menuItem.getTitle().toString();

                //mSelectedMenuItem = menuItem;
                //CLOSING DRAWER WHEN USER CLICK ON ANY MENU
                mDrawerLayout.closeDrawers();

                if (mTitle.equals(getString(R.string.logout))) {
                    //askForLogout();
                } else {

                    initFragement();
                    //SETTING UP TILE ACCORDING TO AFTER SELECTING MENU
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    /*
     * METHOD FOR FRAGEMENT TRANSACTION STARTING
     * */
    private void initFragement() {
        try {
            mFragementTransaction = mFragementManager.beginTransaction();
            Bundle args = null;

            if (mTitle.equals(getString(R.string.job_post))) {
                mSelectedFragment = new JobListingFragment();

                args = new Bundle();
                if (getFragementByTag() instanceof JobListingFragment) {
                    mDrawerLayout.closeDrawers();
                    return;
                }
            } else if (mTitle.equals(getString(R.string.add_post))) {
                mSelectedFragment = new AddJobPostFragment();
                args = new Bundle();
                if (getFragementByTag() instanceof AddJobPostFragment) {
                    mDrawerLayout.closeDrawers();
                    return;
                }
            }

            if (mSelectedFragment != null) {
                mtoolbar.setTitle(mTitle);
                mSelectedFragment.setArguments(args);
                mFragementTransaction.replace(R.id.content_frame, mSelectedFragment);
                mFragementTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                mFragementTransaction.addToBackStack(null);
                mFragementTransaction.commit();
                if (mDrawerLayout != null) mDrawerLayout.closeDrawers();
                invalidateOptionsMenu();
            }else{

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Fragment getFragementByTag() {
        return getSupportFragmentManager().findFragmentById(R.id.content_frame);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}

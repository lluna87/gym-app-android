package com.lmlunadev.gymapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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

import com.lmlunadev.gymapp.R;
import com.lmlunadev.gymapp.fragments.HomeFragment;
import com.lmlunadev.gymapp.listeners.MainFABButtonListener;
import com.lmlunadev.gymapp.listeners.MenuActionListener;
import com.lmlunadev.gymapp.utils.FragmentConstants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_activity_content);

        /* Toolbar setting */
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* Actions menu settings */
        DrawerLayout drawer = (DrawerLayout) this.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        /* FAB settings */
        FloatingActionButton fab = (FloatingActionButton) this.findViewById(R.id.fab);
        fab.setOnClickListener(new MainFABButtonListener(this));

        /* Add action listener to menu */
        NavigationView navigationView = (NavigationView) this.findViewById(R.id.nav_view);
        MenuActionListener menuActionListener = new MenuActionListener(this);
        navigationView.setNavigationItemSelectedListener(menuActionListener);

        /* Load home content */
        this.loadHomeContent();
    }

    private void loadHomeContent() {
        View mainContentFrame = this.findViewById(R.id.main_content_fragment_frame);
        if (mainContentFrame != null){
            FragmentManager fragmentManager = this.getSupportFragmentManager();

            /* Get existent fragment */
            Fragment currentFragment = fragmentManager.findFragmentById(R.id.main_content_fragment_frame);
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            /* Check if current fragment is null */
            if (currentFragment == null){
                /* There's no loaded fragment, create new one */
                currentFragment = new HomeFragment();
                transaction.add(R.id.main_content_fragment_frame, currentFragment);
            }
            else {
                /* There is a fragment */
                Fragment routineFragment = fragmentManager.findFragmentByTag(FragmentConstants.RoutineAdminTag);
                if (routineFragment == null){
                    routineFragment = new HomeFragment();
                }
                else {
                    transaction.remove(routineFragment);
                }
                transaction.remove(currentFragment).add(R.id.main_content_fragment_frame, routineFragment);
            }

            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.addToBackStack(FragmentConstants.RoutineAdminTag);
            transaction.commit();
        }
    }

    /* Overrided methods */

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) this.findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

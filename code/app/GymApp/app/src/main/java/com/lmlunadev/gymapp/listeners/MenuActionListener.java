package com.lmlunadev.gymapp.listeners;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.lmlunadev.gymapp.R;
import com.lmlunadev.gymapp.activities.MainActivity;
import com.lmlunadev.gymapp.fragments.HomeFragment;
import com.lmlunadev.gymapp.fragments.RoutineAdminFragment;
import com.lmlunadev.gymapp.utils.FragmentConstants;

/**
 * Created by Luis on 16/01/2016.
 */
public class MenuActionListener implements NavigationView.OnNavigationItemSelectedListener {

    /* Activity that created the listener instance */
    private MainActivity mainActivity;

    public MenuActionListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        /* Handle navigation view item clicks here. */
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) this.mainActivity.findViewById(R.id.drawer_layout);

        switch (id){
            case R.id.nav_home:{
                this.goHomeAction();
                break;
            }
            case R.id.nav_add_routine:{
                this.setUpAddRoutineAction();
                break;
            }
            default:{

                break;
            }
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setUpAddRoutineAction() {
        /* Check if main content fragment is not null */
        if (this.mainActivity.findViewById(R.id.main_content_fragment_frame) != null){
            FragmentManager fragmentManager = this.mainActivity.getSupportFragmentManager();

            /* Get existent fragment */
            Fragment currentFragment = fragmentManager.findFragmentById(R.id.main_content_fragment_frame);
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            /* Check if current fragment is null */
            if (currentFragment == null){
                /* There's no loaded fragment, create new one */
                currentFragment = new RoutineAdminFragment();
                transaction.add(R.id.main_content_fragment_frame, currentFragment);
            }
            else {
                /* There is a fragment */
                Fragment routineFragment = fragmentManager.findFragmentByTag(FragmentConstants.RoutineAdminTag);
                if (routineFragment == null){
                    routineFragment = new RoutineAdminFragment();
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

    private void goHomeAction() {
        /* Check if main content fragment is not null */
        if (this.mainActivity.findViewById(R.id.main_content_fragment_frame) != null){
            FragmentManager fragmentManager = this.mainActivity.getSupportFragmentManager();

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
                Fragment homeFragment = fragmentManager.findFragmentByTag(FragmentConstants.HomeTag);
                if (homeFragment == null){
                    homeFragment = new HomeFragment();
                }
                else {
                    transaction.remove(homeFragment);
                }
                transaction.remove(currentFragment).add(R.id.main_content_fragment_frame, homeFragment);
            }

            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.addToBackStack(FragmentConstants.HomeTag);
            transaction.commit();
        }
    }
}

package com.lmlunadev.gymapp.listeners;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainFABButtonListener implements View.OnClickListener {

    private AppCompatActivity mainActivity;

    public MainFABButtonListener(AppCompatActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    public AppCompatActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(AppCompatActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
}

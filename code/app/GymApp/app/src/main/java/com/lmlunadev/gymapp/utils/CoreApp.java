package com.lmlunadev.gymapp.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by Luis on 23/01/2016.
 * This Class allows the app to get a global context from anywhere.
 * Its original purpose is provide an alternative to access value
 * resources from any other class in the app.
 */
public class CoreApp extends Application {

    private static Context globalContext;

    @Override
    public void onCreate() {
        super.onCreate();
        globalContext = this;
    }

    public static Context getContext(){
        return globalContext;
    }
}
package com.chapslife.septatest;

import android.app.Application;

import com.chapslife.septatest.utils.RequestManager;

/**
 * Created by kchapman on 10/24/13.
 */
public class SeptaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //initialize the request manager for volley api calls
        RequestManager.init(this);
    }
}

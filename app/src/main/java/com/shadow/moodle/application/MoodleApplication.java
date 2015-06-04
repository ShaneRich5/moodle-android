package com.shadow.moodle.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by Shane on 6/3/2015.
 */
public class MoodleApplication extends Application {
    private static MoodleApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static MoodleApplication getInstance() {
        return sInstance;
    }

    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }
}

package com.shadow.moodle.tasks;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.shadow.moodle.callbacks.TokenLoadedListener;
import com.shadow.moodle.extras.MoodleUtils;
import com.shadow.moodle.network.VolleySingleton;

/**
 * Created by Shane on 6/3/2015.
 */
public class TaskRetrieveToken extends AsyncTask<Void, Void, String> {
    private TokenLoadedListener mComponent;
    private VolleySingleton mVolleySingleton;
    private RequestQueue requestQueue;
    private String username, password;

    public TaskRetrieveToken(TokenLoadedListener mComponent, String username, String password) {
        this.mComponent = mComponent;
        mVolleySingleton = VolleySingleton.getsInstance();
        requestQueue = mVolleySingleton.getRequestQueue();
        this.username = username;
        this.password = password;
    }

    @Override
    protected String doInBackground(Void... params) {
        return MoodleUtils.loadToken(requestQueue, username, password);
    }

    @Override
    protected void onPostExecute(String token) {
        if (mComponent != null)
            mComponent.onTokenLoaded(token);
    }
}

package com.shadow.moodle.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.shadow.moodle.callbacks.CredentialsLoadedListener;
import com.shadow.moodle.extras.MoodleUtils;
import com.shadow.moodle.network.VolleySingleton;

/**
 * Created by Shane on 6/3/2015.
 */
public class TaskRetrieveToken extends AsyncTask<Void, Void, String> {
    private CredentialsLoadedListener mComponent;
    private RequestQueue requestQueue;
    private String username, password;

    public TaskRetrieveToken(CredentialsLoadedListener mComponent, String username, String password) {
        this.mComponent = mComponent;
        requestQueue = VolleySingleton.getsInstance().getRequestQueue();
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
        Log.w("TaskRetrieveToken", token + " ");
    }
}

package com.shadow.moodle.tasks;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.shadow.moodle.callbacks.CredentialsLoadedListener;
import com.shadow.moodle.extras.MoodleUtils;
import com.shadow.moodle.logger.Logger;
import com.shadow.moodle.model.User;
import com.shadow.moodle.network.VolleySingleton;

/**
 * Created by Shane on 6/4/2015.
 */
public class TaskLoadUserDetails extends AsyncTask<Void, Void, User> {
    private CredentialsLoadedListener mComponent;
    private RequestQueue requestQueue;
    private String token;

    public TaskLoadUserDetails(CredentialsLoadedListener mComponent, String token) {
        requestQueue = VolleySingleton.getsInstance().getRequestQueue();
        this.mComponent = mComponent;
        this.token = token;
    }

    @Override
    protected User doInBackground(Void... params) {
        return MoodleUtils.loadUserDetails(requestQueue, token);
    }

    @Override
    protected void onPostExecute(User user) {
        Logger.m(user.getId() + "");
        if (mComponent != null)
            mComponent.onUserDetailsLoaded(user);
    }
}

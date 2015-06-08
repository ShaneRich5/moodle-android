package com.shadow.moodle.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shadow.moodle.model.User;
import com.shadow.moodle.sessions.SessionManager;
import com.shadow.moodle.tasks.TaskLoadUserDetails;
import com.shadow.moodle.tasks.TaskRetrieveToken;

import java.util.HashMap;

/**
 * Created by Shane on 6/4/2015.
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    protected TaskRetrieveToken mAuthTask = null;
    protected TaskLoadUserDetails mProfileTask = null;

    /**
     * Manages the session for all activities,
     */
    protected SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new SessionManager(this);
    }

    protected void createSession(String username, String token) {
        session.createLoginSession(username, token);
    }

    protected void saveUserId(int id) {
        session.addUserId(id);
    }

    public HashMap<String, String> getSessionInfo(){
        return session.getUserDetails();
    }
}

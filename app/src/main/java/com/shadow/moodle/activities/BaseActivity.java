package com.shadow.moodle.activities;

import android.support.v7.app.AppCompatActivity;

import com.shadow.moodle.model.User;
import com.shadow.moodle.sessions.SessionManager;
import com.shadow.moodle.tasks.TaskLoadUserDetails;
import com.shadow.moodle.tasks.TaskRetrieveToken;

/**
 * Created by Shane on 6/4/2015.
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    protected TaskRetrieveToken mAuthTask = null;
    protected TaskLoadUserDetails mProfileTask = null;

    protected SessionManager session;

    protected void createSession(String username, String token) {
        session = new SessionManager(this);
        session.createLoginSession(username, token);
    }

    protected void addUserDetailsToSession(User user) {
        session = new SessionManager(this);
        session.addUserDetails(user);
    }
}

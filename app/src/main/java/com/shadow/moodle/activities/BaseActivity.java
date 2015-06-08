package com.shadow.moodle.activities;

import android.content.Intent;
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

    protected HashMap<String, String> getSessionInfo(){
        return session.getUserDetails();
    }

    protected boolean checkLogin() {
        return session.isLoggedIn();
    }

    protected void openLoginScreen() {
        if (!checkLogin()) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(intent);
        }
    }
}

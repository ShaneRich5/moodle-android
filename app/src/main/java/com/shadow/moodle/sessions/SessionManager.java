package com.shadow.moodle.sessions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.shadow.moodle.activities.LoginActivity;
import com.shadow.moodle.application.MoodleApplication;
import com.shadow.moodle.model.User;

import java.util.HashMap;

/**
 * Created by Shane on 6/4/2015.
 */
public class SessionManager {
    public static final String PREF_NAME = "MoodleUserSessionPref";
    private final int PRIVATE_MODE = 0;

    private SharedPreferences preferences;
    private Editor editor;
    private Context context;

    public static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_FIRST_NAME = "firstName";
    public static final String KEY_LAST_NAME = "lastName";
    public static final String KEY_USER_ID = "user_id";

    @SuppressLint("CommitPrefEdits")
    public SessionManager(Context context) {
        this.context = context;
        preferences = this.context
                .getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public void createLoginSession(String username, String token){
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_TOKEN, token);
        editor.apply();
    }

    public void addUserId(int id) {
        editor.putInt(KEY_USER_ID, id);
        editor.apply();
    }

    public void addUserDetails(User user) {
        editor.putString(KEY_FIRST_NAME, user.getFirstName());
        editor.putString(KEY_LAST_NAME, user.getLastName());
        editor.putLong(KEY_USER_ID, user.getId());
        editor.apply();
    }

    public boolean isLoggedIn() {
        return preferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    // TODO
    public void checkLogin() {
        if (!this.isLoggedIn()) {
            Intent intent = new Intent(context, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            context.startActivity(intent);
        }
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> userDetails = new HashMap<>();
        userDetails.put(KEY_USERNAME, preferences.getString(KEY_USERNAME, null));
        userDetails.put(KEY_TOKEN, preferences.getString(KEY_TOKEN, null));
        userDetails.put(KEY_USER_ID, String.valueOf(preferences.getInt(KEY_USER_ID, 0)));
        return userDetails;
    }

    public void logoutUser() {
        editor.clear();
        editor.apply();
    }
}

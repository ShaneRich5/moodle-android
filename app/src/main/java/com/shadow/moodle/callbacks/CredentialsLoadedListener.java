package com.shadow.moodle.callbacks;

import com.shadow.moodle.model.User;

/**
 * Created by Shane on 6/3/2015.
 */
public interface CredentialsLoadedListener {
    void onTokenLoaded(String token);
    void onUserDetailsLoaded(User user);
}

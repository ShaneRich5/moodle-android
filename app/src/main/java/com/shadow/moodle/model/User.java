package com.shadow.moodle.model;

import com.shadow.moodle.extras.Keys;
import com.shadow.moodle.json.Utils;
import com.shadow.moodle.logger.Logger;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Shane on 6/3/2015.
 */
public class User {
    private long id;
    private String token, username, password, firstName, lastName;

    public User(JSONObject jsonObject) {
        if ((jsonObject != null) && (jsonObject.length() > 0)) {
            try {
                if (Utils.contains(jsonObject, Keys.KEY_FIRST_NAME))
                    this.firstName = jsonObject.getString(Keys.KEY_FIRST_NAME);
                if (Utils.contains(jsonObject, Keys.KEY_LAST_NAME))
                    this.lastName = jsonObject.getString(Keys.KEY_LAST_NAME);
                if (Utils.contains(jsonObject, Keys.KEY_USER_ID)) {
                    this.id = jsonObject.getLong(Keys.KEY_USER_ID);
                    Logger.m(this.id + " ");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

package com.shadow.moodle.extras;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.shadow.moodle.json.Endpoint;
import com.shadow.moodle.json.Parser;
import com.shadow.moodle.json.Requestor;
import com.shadow.moodle.model.Course;
import com.shadow.moodle.model.User;

import org.json.JSONObject;

import java.net.Authenticator;

/**
 * Created by Shane on 6/3/2015.
 */
public class MoodleUtils {
    public static String loadToken(RequestQueue requestQueue, String username, String password) {
        Log.w("url", Endpoint.getMoodleToken(username, password));
        JSONObject response = Requestor.getRequestJSON(requestQueue, Endpoint.getMoodleToken(username, password));
        String token = Parser.parseTokenJSON(response);
        return token;
    }

    public static User loadUserDetails(RequestQueue requestQueue, String token) {
        Log.w("MoodleUtils", Endpoint.getUserDetails(token));
        JSONObject response = Requestor.getRequestJSON(requestQueue, Endpoint.getUserDetails(token));
        return User.fromJSON(response);
    }

    public static Course loadCourse(RequestQueue requestQueue, String userId, String tokeken) {
        JSONObject response = Requestor.getRequestJSON(requestQueue, Endpoint.getUserDetails(" "));
        return Course.fromJSON(response);
    }
}

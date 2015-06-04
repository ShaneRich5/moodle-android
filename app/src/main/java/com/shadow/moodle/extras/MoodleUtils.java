package com.shadow.moodle.extras;

import com.android.volley.RequestQueue;
import com.shadow.moodle.json.Endpoint;
import com.shadow.moodle.json.Parser;
import com.shadow.moodle.json.Requestor;

import org.json.JSONObject;

import java.net.Authenticator;

/**
 * Created by Shane on 6/3/2015.
 */
public class MoodleUtils {
    public static String loadToken(RequestQueue requestQueue, String username, String password) {
        JSONObject response = Requestor.requestTokenJSON(requestQueue, Endpoint.getMoodleToken(username, password));
        return Parser.parseTokenJSON(response);
    }
}

package com.shadow.moodle.json;

import com.shadow.moodle.extras.Keys;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Shane on 6/4/2015.
 */
public class Parser {
    public static String parseTokenJSON(JSONObject response) {
        if ((response != null) && (response.length() > 0)) {
            if (Utils.contains(response, Keys.KEY_TOKEN)) {
                try {
                    return response.getString(Keys.KEY_TOKEN);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

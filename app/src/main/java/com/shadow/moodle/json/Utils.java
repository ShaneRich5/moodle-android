package com.shadow.moodle.json;

import org.json.JSONObject;

/**
 * Created by Shane on 6/3/2015.
 */
public class Utils {
    public static boolean contains(JSONObject jsonObject, String key) {
        return jsonObject != null && jsonObject.has(key) && !jsonObject.isNull(key);
    }
}

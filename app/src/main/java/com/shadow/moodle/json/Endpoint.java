package com.shadow.moodle.json;

import static com.shadow.moodle.extras.UrlEnpoints.*;
import static com.shadow.moodle.extras.UrlEnpoints.Char.*;
import static com.shadow.moodle.extras.UrlEnpoints.Param.*;
import static com.shadow.moodle.extras.UrlEnpoints.Query.*;

/**
 * Created by Shane on 6/4/2015.
 */
public class Endpoint {
    public static String getMoodleToken(String username, String password) {
        return URL_BASE + LOGIN + TOKEN +
                QUESTION + USERNAME + username +
                AMPERSAND + PASSWORD + password +
                AMPERSAND + SERVICE;
    }

    public static String getUserDetails(String token) {
        return URL_BASE + WEBSERVICE + REST + SERVER +
                QUESTION + WS_TOKEN + token +
                AMPERSAND + WS_FUNCTION + CORE_WEBSERVICE_GET_SITE_INFO +
                AMPERSAND + MOODLE_WS_REST_FORMAT;
    }

    public static String getCoursesList(String token, int userId) {
        return URL_BASE + WEBSERVICE + REST + SERVER +
                QUESTION + WS_TOKEN + token +
                AMPERSAND + WS_TOKEN + CORE_ENROL_GET_USERS_COURSES +
                AMPERSAND + USER_ID + userId +
                AMPERSAND + MOODLE_WS_REST_FORMAT;
    }
}

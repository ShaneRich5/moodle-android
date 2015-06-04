package com.shadow.moodle.json;

import com.shadow.moodle.extras.UrlEnpoints;

import static com.shadow.moodle.extras.UrlEnpoints.*;
import static com.shadow.moodle.extras.UrlEnpoints.Char.*;
import static com.shadow.moodle.extras.UrlEnpoints.Query.*;

/**
 * Created by Shane on 6/4/2015.
 */
public class Endpoint {
//    http://ourvle.mona.uwi.edu/login/token.php?username=620065739&password=19941206&service=moodle_mobile_app
    public static String getMoodleToken(String username, String password) {
        return URL_BASE + LOGIN + TOKEN + QUESTION +
                AMPERSAND + USERNAME + username +
                AMPERSAND + PASSWORD + password +
                AMPERSAND + SERVICE;
    }
}

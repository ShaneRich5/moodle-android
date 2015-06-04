package com.shadow.moodle.extras;

/**
 * Created by Shane on 6/4/2015.
 */
public class UrlEnpoints {
    public static final String URL_BASE = "http://ourvle.mona.uwi.edu/";

    public static final String LOGIN = "login/";
    public static final String WEBSERVICE = "webservice/";
    public static final String REST = "rest/";

    public static final String TOKEN = "token.php";
    public static final String SERVER = "server.php";

    public class Query {
        public static final String SERVICE = "service=moodle_mobile_app";
        public static final String MOODLE_WS_REST_FORMAT = "moodlewsrestformat=json";
        public static final String USERNAME = "username=";
        public static final String PASSWORD = "password=";
        public static final String WS_TOKEN = "wstoken=";
        public static final String WS_FUNCTION = "wsfunction=";
    }

    public class Char {
        public static final String QUESTION = "?";
        public static final String AMPERSAND = "&";
    }

    public class Param {
        public static final String CORE_WEBSERVICE_GET_SITE_INFO = "core_webservice_get_site_info";
    }
}
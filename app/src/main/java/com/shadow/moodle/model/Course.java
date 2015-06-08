package com.shadow.moodle.model;

import org.json.JSONObject;

/**
 * Created by Shane on 6/7/2015.
 */
public class Course {
    public String id, title, code;

    public Course() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private Course(JSONObject json) {

    }

    public static Course fromJSON(JSONObject json) {
        return new Course(json);
    }
}

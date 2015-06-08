package com.shadow.moodle.tasks;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.shadow.moodle.callbacks.CourseListLoadedListener;
import com.shadow.moodle.extras.MoodleUtils;
import com.shadow.moodle.model.Course;
import com.shadow.moodle.network.VolleySingleton;

import java.util.ArrayList;

/**
 * Created by Shane on 6/4/2015.
 */
public class TaskLoadUserCourses extends AsyncTask<Void, Void, ArrayList<Course>> {
    private CourseListLoadedListener mComponent;
    private RequestQueue requestQueue;
    private String token;
    private int userId;

    public TaskLoadUserCourses(CourseListLoadedListener mComponent, RequestQueue requestQueue, String token, int userId) {
        this.mComponent = mComponent;
        this.requestQueue = VolleySingleton.getsInstance().getRequestQueue();
        this.token = token;
        this.userId = userId;
    }

    @Override
    protected ArrayList<Course> doInBackground(Void... params) {
        return MoodleUtils.loadCoursesList();
    }
}

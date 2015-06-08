package com.shadow.moodle.callbacks;

import com.shadow.moodle.model.Course;

import java.util.ArrayList;

/**
 * Created by Shane on 6/8/2015.
 */
public interface CourseListLoadedListener {
    void onCourseListLoaded(ArrayList<Course> courseList);
}

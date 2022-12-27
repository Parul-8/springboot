package com.restapis.RestApis.service;

import java.util.List;

import com.restapis.RestApis.beans.Courses;

public interface RestApisService {
	
	public List<Courses> getCourses();
	public Courses getCourse(long courseId);
	public Courses addCourse(Courses course);
	public Courses updateCourse(Courses course);
	public void deleteCourse(long courseId);

}

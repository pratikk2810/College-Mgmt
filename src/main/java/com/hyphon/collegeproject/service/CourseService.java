package com.hyphon.collegeproject.service;

import java.util.List;

import com.hyphon.collegeproject.entity.Course;

public interface CourseService {

	List<Course> getCourses();

	Course getCourse(Long courseId);

	Course createCourse(Course course);

	boolean updateCourse(Long courseId,Course course);

	boolean deleteCourse(Long courseId);

}

package com.hyphon.collegeproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyphon.collegeproject.entity.Course;
import com.hyphon.collegeproject.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	@Override
	public List<Course> getCourses() {
		List<Course> courses = courseRepository.findAll();
		return courses;
	}
	@Override
	public Course getCourse(Long courseId) {
		Course course = courseRepository.getById(courseId);
		return course;
	}
	@Override
	public Course createCourse(Course course) {
		
		Course outCourse = courseRepository.save(course);
		return outCourse;
	}

}

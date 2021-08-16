package com.hyphon.collegeproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyphon.collegeproject.entity.Course;
import com.hyphon.collegeproject.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> getCourses() {
		List<Course> courses = courseService.getCourses();
		return courses;
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable("id") Long courseId) {
		Course course = courseService.getCourse(courseId);
		return course;
	}
	
	@PostMapping("/courses")
	public Course createCourse(@RequestBody Course course) {
		
		Course Outcourse = courseService.createCourse(course);
		return Outcourse;
	}
}

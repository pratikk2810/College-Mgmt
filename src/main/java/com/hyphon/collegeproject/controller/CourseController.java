package com.hyphon.collegeproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<?> getCourse(@PathVariable("id") Long courseId) {
		Course course = courseService.getCourse(courseId);
		if(course!=null)
			return ResponseEntity.ok(course);
		return new ResponseEntity<String>("Course Not Available with given course ID", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/courses")
	public Course createCourse(@Valid @RequestBody Course course) {
		Course Outcourse = courseService.createCourse(course);
		return Outcourse;
	}
	
	@PutMapping("/courses/{courseId}")
	public String updateCourse(@Valid @PathVariable("courseId") Long courseId, @RequestBody Course course) {
		
		String message = "Course is not available.";
		course.setCourseId(courseId);
		if(courseService.updateCourse(courseId, course)) {
			message = "Course updated successfully.";
		}
		return message;
	}
	
	@DeleteMapping("/courses/{courseId}")
	public String deleteCourse(@PathVariable("courseId") Long courseId) {
		String message = "Course is not available";
		
		if(courseService.deleteCourse(courseId)) {
			message = "Course is Deleted.";
		}
		return message;
	}
}

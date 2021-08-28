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
		if(courseRepository.existsById(courseId)) {
			Course course = courseRepository.findById(courseId).get();
			return course;
		}
		return null;
	}
	@Override
	public Course createCourse(Course course) {
		
		Course outCourse = courseRepository.save(course);
		return outCourse;
	}
	@Override
	public boolean updateCourse(Long courseId, Course course) {
		if(courseRepository.existsById(courseId)) {
			courseRepository.save(course);
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteCourse(Long courseId) {
		if(courseRepository.existsById(courseId)) {
			courseRepository.deleteById(courseId);
			return true;
		}
		return false;
	}

}

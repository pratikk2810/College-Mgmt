package com.hyphon.collegeproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyphon.collegeproject.entity.Student;
import com.hyphon.collegeproject.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String getMessage() {
		return "Welcome back";
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		List<Student> studentList = studentService.getStudents();
		System.out.println("Student List : "+studentList);
		return studentList;
	}
	
	@GetMapping("/students/{studentId}")
	public Optional<Student> getStudent(@PathVariable("studentId") Long studentId) {
		
		Optional<Student> student = studentService.getStudent(studentId);
		System.out.println("Student List : "+student);
		return student;
	}
	
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		System.out.println("Student :"+student);
		studentService.createStudent(student);
		return student;
	}
	
}

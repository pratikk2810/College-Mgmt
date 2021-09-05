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
import com.hyphon.collegeproject.entity.Student;
import com.hyphon.collegeproject.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		List<Student> studentList = studentService.getStudents();
		return studentList;
	}
	
	@GetMapping("/students/{studentId}")
	public ResponseEntity<?> getStudent(@PathVariable("studentId") Long studentId) {
		
		Student student = studentService.getStudent(studentId);
		if(student != null) {
			return ResponseEntity.ok(student);
		}
		return new ResponseEntity<String>("Student not available.",HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student student) {
		studentService.createStudent(student);
		return student;
	}
	
	@PutMapping("/students/{studentId}")
	public String updateStudent(@Valid @PathVariable("studentId") Long studentId, @RequestBody Student student) {
		
		String message = "Student is not available.";
		if(studentService.updateStudent(studentId, student)) {
			message = "Student Updated.";
		}
		return message;
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable("studentId") Long studentId) {
		
		String message = "Student is not available.";
		if(studentService.deleteStudent(studentId)) {
			message = "Student Deleted.";
		}
		return message;
	}
}

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

import com.hyphon.collegeproject.entity.Teacher;
import com.hyphon.collegeproject.service.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	TeacherService teacherService;
	
	@GetMapping("/teachers")
	public List<Teacher> getTeachers() {
		
		List<Teacher> teachers = teacherService.getTeachers();
		return teachers;
	}
	
	@GetMapping("/teachers/{teacherId}")
	public ResponseEntity<?> getTeacher(@PathVariable("teacherId") Long teacherId) {
		
		Teacher teacher = teacherService.getTeacher(teacherId);
		if(teacher != null)
			return ResponseEntity.ok(teacher);
		return new ResponseEntity<String>("Teacher is not available", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/teachers")
	public Teacher createTeacher(@Valid @RequestBody Teacher teacher) {
		Teacher outTeacher = teacherService.createTeacher(teacher);
		return outTeacher;
	}
	
	@PutMapping("/teachers/{teacherId}")
	public String updateTeacher(@Valid @PathVariable("teacherId") Long teacherId, @RequestBody Teacher teacher) {
		
		String message = "Teacher is not available.";
		if(teacherService.updateTeacher(teacherId, teacher)) {
			message = "Teacher is updated successfully.";
		}
		return message;
	}
	
	@DeleteMapping("/teachers/{teacherId}")
	public String deleteTeacher(@PathVariable("teacherId") Long teacherId) {
		
		String message = "Teacher is not available";
		if(teacherService.deleteTeacher(teacherId))
			message = "Teacher is deleted";
		return message;
	}
}

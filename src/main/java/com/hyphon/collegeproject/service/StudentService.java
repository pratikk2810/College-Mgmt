package com.hyphon.collegeproject.service;

import java.util.List;
import java.util.Optional;

import com.hyphon.collegeproject.entity.Student;

public interface StudentService {

	List<Student> getStudents();
	Student createStudent(Student student);
	Optional<Student> getStudent(Long studentId);
}

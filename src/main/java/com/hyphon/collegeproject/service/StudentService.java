package com.hyphon.collegeproject.service;

import java.util.List;
import com.hyphon.collegeproject.entity.Student;

public interface StudentService {

	List<Student> getStudents();
	Student createStudent(Student student);
	Student getStudent(Long studentId);
	boolean updateStudent(Long studentId, Student student);
	boolean deleteStudent(Long studentId);
}

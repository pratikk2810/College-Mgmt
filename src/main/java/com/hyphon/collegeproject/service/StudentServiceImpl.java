package com.hyphon.collegeproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyphon.collegeproject.entity.Student;
import com.hyphon.collegeproject.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public List<Student> getStudents() {
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}
	
	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Optional<Student> getStudent(Long studentId) {
		
		return studentRepository.findById(studentId);
	}

}

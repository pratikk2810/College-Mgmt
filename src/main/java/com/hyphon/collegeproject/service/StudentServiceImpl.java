package com.hyphon.collegeproject.service;

import java.util.List;
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
	public Student getStudent(Long studentId) {
		
		if(studentRepository.existsById(studentId)) {
			return studentRepository.findById(studentId).get();
		}
		return null;
	}

	@Override
	public boolean updateStudent(Long studentId, Student student) {
		if(studentRepository.existsById(studentId)) {
			studentRepository.save(student);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStudent(Long studentId) {
		if(studentRepository.existsById(studentId)) {
			studentRepository.deleteById(studentId);
			return true;
		}
		return false;
	}

}

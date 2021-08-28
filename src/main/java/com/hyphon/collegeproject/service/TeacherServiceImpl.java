package com.hyphon.collegeproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyphon.collegeproject.entity.Teacher;
import com.hyphon.collegeproject.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	@Override
	public List<Teacher> getTeachers() {
		return teacherRepository.findAll();
	}
	
	@Override
	public Teacher getTeacher(Long teacherId) {
		if( teacherRepository.existsById(teacherId)) {
			return teacherRepository.findById(teacherId).get();
		}
		return null;
	}
	
	@Override
	public Teacher createTeacher(Teacher teacher) {
		Teacher outTeacher = teacherRepository.save(teacher);
		return outTeacher;
	}

	@Override
	public boolean updateTeacher(Long teacherId, Teacher teacher) {
		if(teacherRepository.existsById(teacherId)) {
			teacherRepository.save(teacher);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteTeacher(Long teacherId) {
		if(teacherRepository.existsById(teacherId)) {
			teacherRepository.deleteById(teacherId);
			return true;
		}
		return false;
	}

}

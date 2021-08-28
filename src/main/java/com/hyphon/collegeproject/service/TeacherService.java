package com.hyphon.collegeproject.service;

import java.util.List;
import com.hyphon.collegeproject.entity.Teacher;


public interface TeacherService {

	List<Teacher> getTeachers();

	Teacher getTeacher(Long teacherId);

	Teacher createTeacher(Teacher teacher);

	boolean updateTeacher(Long teacherId, Teacher teacher);

	boolean deleteTeacher(Long teacherId);

}

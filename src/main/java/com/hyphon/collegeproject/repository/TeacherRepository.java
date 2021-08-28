package com.hyphon.collegeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyphon.collegeproject.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}

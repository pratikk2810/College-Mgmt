package com.hyphon.collegeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyphon.collegeproject.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}

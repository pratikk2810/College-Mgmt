package com.hyphon.collegeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyphon.collegeproject.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}

package com.hyphon.collegeproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

	@Id
	@SequenceGenerator(name = "teacherSequence", sequenceName = "teacherSequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacherSequence")
	private Long teacherId;
	private String teacherName;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	private List<Course> courses;
	
}
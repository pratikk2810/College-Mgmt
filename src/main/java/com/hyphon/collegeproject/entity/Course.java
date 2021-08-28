package com.hyphon.collegeproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Course {

	@Id
	@SequenceGenerator(name ="courseSequence", sequenceName = "CourseSequence", allocationSize = 1)
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "courseSequence")
	private Long courseId;
	private String courseName;
	private Integer credits;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(
			
			name="course_material_id",
			referencedColumnName = "courseMaterialId"
	)
	private CourseMaterial courseMaterial;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(
	
			name="teacher_id",
			referencedColumnName = "teacherId"
	)
	@JsonBackReference
	private Teacher teacher;
	
}

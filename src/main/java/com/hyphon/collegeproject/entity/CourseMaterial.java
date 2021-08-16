package com.hyphon.collegeproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {

	@Id
	@SequenceGenerator(name = "courseMaterialSequence", sequenceName = "courseMaterialSequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseMaterialSequence")
	private Long courseMaterialId;
	private String url;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(
	
			name="course_id",
			referencedColumnName = "courseId"
	)
	private Course course;
}

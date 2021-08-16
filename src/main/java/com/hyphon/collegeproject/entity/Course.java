package com.hyphon.collegeproject.entity;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	private CourseMaterial courseMaterial;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(
	
			name="teacher_id",
			referencedColumnName = "teacherId"
	)
	private Teacher teacher;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_course",
			joinColumns = @JoinColumn(name="course_id", referencedColumnName = "courseId"),
			inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId")
	)
	private List<Student> studentList;
}

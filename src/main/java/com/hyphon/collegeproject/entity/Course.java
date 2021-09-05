package com.hyphon.collegeproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
	@NotBlank(message = "Course name should not be blank.")
	@Size(min = 3, max = 15, message = "Course name should between 3 to 15 characters.")
	private String courseName;
	@NotNull(message = "Credits should not be null.")
	@Min(value = 1, message = "Credits should between 1 to 10.")
	@Max(value = 10, message = "Credits should between 1 to 10.")
	private Integer credits;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(
			
			name="course_material_id",
			referencedColumnName = "courseMaterialId"
	)
	@NotNull(message = "Course Material should not be Null.")
	private CourseMaterial courseMaterial;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(
	
			name="teacher_id",
			referencedColumnName = "teacherId"
	)
	@JsonBackReference
	private Teacher teacher;
}

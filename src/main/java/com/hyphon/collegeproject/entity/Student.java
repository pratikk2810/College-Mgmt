package com.hyphon.collegeproject.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
			)
	private Long studentId;
	@NotBlank(message = "First name should not blank or null.")
	@Size(min = 3, message = "First name should contain atleast 3 characters.")
	private String firstName;
	@NotBlank(message = "Last name should not blank or null.")
	@Size(min = 3, message = "Last name should contain atleast 3 characters.")
	private String lastName;
	
	@Embedded
	@NotNull(message = "Guardian should not be null.")
	private Guardian guardian;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_course",
			joinColumns = @JoinColumn(name="student_id", referencedColumnName = "studentId"),
			inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId")
	)
	@NotNull(message = "Course should not be null.")
	private List<Course> courses;
}

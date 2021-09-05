package com.hyphon.collegeproject.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
	@NotBlank(message = "Teacher name should not be blank or null.")
	@Size(min = 3, max = 30, message = "Teacher name should between 3 to 30 characters.")
	private String teacherName;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	@NotNull(message = "Course should not be null while entering Teacher.")
	@NotEmpty(message = "Course should not be null while entering Teacher.")
	private List<Course> courses;
	
}
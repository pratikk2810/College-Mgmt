package com.hyphon.collegeproject.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
	@AttributeOverride(
			name="guardianName",
			column = @Column(name="guardian_name")
			),
	@AttributeOverride(
			name="guardianEmail",
			column = @Column(name="guardian_email")
			),
	@AttributeOverride(
			name="guardianMobile",
			column = @Column(name="guardian_mobile"))
})
public class Guardian {

	@NotBlank(message = "Guardian Name should not be null or empty.")
	@Size(min = 3, message = "Guardian Name should atleast 3 characters.")
	private String guardianName;
	@Email(message = "Email should be well-formatt email.")
	private String guardianEmail;
	@Size(min = 10, max = 10, message = "Mobile should be 10 digits.")
	private Long guardianMobile;	
}

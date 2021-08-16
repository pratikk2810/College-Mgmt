package com.hyphon.collegeproject.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

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

	private String guardianName;
	private String guardianEmail;
	private Long guardianMobile;	
}

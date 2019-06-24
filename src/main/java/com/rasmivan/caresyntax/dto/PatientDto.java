package com.rasmivan.caresyntax.dto;

import java.time.Instant;

/**
 * The Class PatientDto.
 */
public class PatientDto {

	/** The id. */
	private Long id;
	
	/** The name. */
	private String name;
	
	/** The sex. */
	private String sex;
	
	/** The date of birth. */
	private Instant dateOfBirth;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the sex.
	 *
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * Sets the sex.
	 *
	 * @param sex the new sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/**
	 * Gets the date of birth.
	 *
	 * @return the date of birth
	 */
	public Instant getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Sets the date of birth.
	 *
	 * @param dateOfBirth the new date of birth
	 */
	public void setDateOfBirth(Instant dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}

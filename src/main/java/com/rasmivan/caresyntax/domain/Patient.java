package com.rasmivan.caresyntax.domain;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The Class Patient.
 */
@Entity
@Table(name = "patient")
public class Patient {
	
	/** The id. */
	private Long id;
	
	/** The name. */
	private String name;
	
	/** The sex. */
	private String sex;
	
	/** The date of birth. */
	private Instant dateOfBirth;
	
	/** The version. */
	private Long version;
	
	/** The study. */
	private Set<Study> study = new HashSet<>(0);
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id", unique = true, nullable = false)
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
	@Column(name = "name", nullable = false)
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
	@Column(name = "sex")
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
	@Column(name = "dateofbirth")
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
	
	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	@Version
	public Long getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
	public void setVersion(Long version) {
		this.version = version;
	} 

	/**
	 * Gets the study.
	 *
	 * @return the study
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@JsonManagedReference
	public Set<Study> getStudy() {
		return study;
	}

	/**
	 * Sets the study.
	 *
	 * @param study the new study
	 */
	public void setStudy(Set<Study> study) {
		this.study = study;
	}

	/**
	 * Instantiates a new patient.
	 *
	 * @param id the id
	 * @param name the name
	 * @param sex the sex
	 * @param dateOfBirth the date of birth
	 * @param version the version
	 */
	public Patient(Long id, String name, String sex, Instant dateOfBirth, Long version) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.version = version;
	}

	/**
	 * Instantiates a new patient.
	 */
	public Patient() {
		super();
	}
	
}

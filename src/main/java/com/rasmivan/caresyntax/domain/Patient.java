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


@Entity
@Table(name = "patient")
public class Patient {
	
	private Long id;
	private String name;
	private String sex;
	private Instant dateOfBirth;
	private Long version;
	private Set<Study> study = new HashSet<>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name = "dateofbirth")
	public Instant getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Instant dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Version
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	} 

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@JsonManagedReference
	public Set<Study> getStudy() {
		return study;
	}

	public void setStudy(Set<Study> study) {
		this.study = study;
	}

	public Patient(Long id, String name, String sex, Instant dateOfBirth, Long version) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.version = version;
	}

	public Patient() {
		super();
	}
	
}

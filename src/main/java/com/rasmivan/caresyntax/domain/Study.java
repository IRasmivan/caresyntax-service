package com.rasmivan.caresyntax.domain;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "study")
public class Study {
	
	private Long id;
	private Patient patient;
	private String description;
	private String status;
	private Instant plannedStartTime;
	private Instant estimatedEndTime;
	private Long version;
	private Set<Schedule> schedule = new TreeSet<>();
	
	private Long patientId;
	private String patientName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient", nullable = false, unique = true)
	@JsonBackReference
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "plannedstarttime", nullable = false)
	public Instant getPlannedStartTime() {
		return plannedStartTime;
	}
	public void setPlannedStartTime(Instant plannedStartTime) {
		this.plannedStartTime = plannedStartTime;
	}
	
	@Column(name = "estimatedendtime")
	public Instant getEstimatedEndTime() {
		return estimatedEndTime;
	}
	public void setEstimatedEndTime(Instant estimatedEndTime) {
		this.estimatedEndTime = estimatedEndTime;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "study")
	@JsonManagedReference
	public Set<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<Schedule> schedule) {
		this.schedule = schedule;
	}
	
	@Version
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	

	public Long getPatientId() {
		return patient.getId();
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patient.getName();
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Study(Long id, String description, String status, Instant plannedStartTime, Instant estimatedEndTime,
			Long version) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.plannedStartTime = plannedStartTime;
		this.estimatedEndTime = estimatedEndTime;
		this.version = version;
	}
	
	
	
	public Study(Long id, Patient patient, String description, String status, Instant plannedStartTime,
			Instant estimatedEndTime, Long version, Set<Schedule> schedule) {
		super();
		this.id = id;
		this.patient = patient;
		this.description = description;
		this.status = status;
		this.plannedStartTime = plannedStartTime;
		this.estimatedEndTime = estimatedEndTime;
		this.version = version;
		this.schedule = schedule;
	}
	public Study() {
		super();
	} 
		
}

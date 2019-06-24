package com.rasmivan.caresyntax.domain;

import java.time.Instant;
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

/**
 * The Class Study.
 */
@Entity
@Table(name = "study")
public class Study {
	
	/** The id. */
	private Long id;
	
	/** The patient. */
	private Patient patient;
	
	/** The description. */
	private String description;
	
	/** The status. */
	private String status;
	
	/** The planned start time. */
	private Instant plannedStartTime;
	
	/** The estimated end time. */
	private Instant estimatedEndTime;
	
	/** The version. */
	private Long version;
	
	/** The schedule. */
	private Set<Schedule> schedule = new TreeSet<>();
	
	/** The patient id. */
	private Long patientId;
	
	/** The patient name. */
	private String patientName;
	
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
	 * Gets the patient.
	 *
	 * @return the patient
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient", nullable = false, unique = true)
	@JsonBackReference
	public Patient getPatient() {
		return patient;
	}
	
	/**
	 * Sets the patient.
	 *
	 * @param patient the new patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Gets the planned start time.
	 *
	 * @return the planned start time
	 */
	@Column(name = "plannedstarttime", nullable = false)
	public Instant getPlannedStartTime() {
		return plannedStartTime;
	}
	
	/**
	 * Sets the planned start time.
	 *
	 * @param plannedStartTime the new planned start time
	 */
	public void setPlannedStartTime(Instant plannedStartTime) {
		this.plannedStartTime = plannedStartTime;
	}
	
	/**
	 * Gets the estimated end time.
	 *
	 * @return the estimated end time
	 */
	@Column(name = "estimatedendtime")
	public Instant getEstimatedEndTime() {
		return estimatedEndTime;
	}
	
	/**
	 * Sets the estimated end time.
	 *
	 * @param estimatedEndTime the new estimated end time
	 */
	public void setEstimatedEndTime(Instant estimatedEndTime) {
		this.estimatedEndTime = estimatedEndTime;
	}
	
	/**
	 * Gets the schedule.
	 *
	 * @return the schedule
	 */
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "study")
	@JsonManagedReference
	public Set<Schedule> getSchedule() {
		return schedule;
	}

	/**
	 * Sets the schedule.
	 *
	 * @param schedule the new schedule
	 */
	public void setSchedule(Set<Schedule> schedule) {
		this.schedule = schedule;
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
	 * Gets the patient id.
	 *
	 * @return the patient id
	 */
	public Long getPatientId() {
		return patient.getId();
	}
	
	/**
	 * Sets the patient id.
	 *
	 * @param patientId the new patient id
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
	/**
	 * Gets the patient name.
	 *
	 * @return the patient name
	 */
	public String getPatientName() {
		return patient.getName();
	}
	
	/**
	 * Sets the patient name.
	 *
	 * @param patientName the new patient name
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	/**
	 * Instantiates a new study.
	 *
	 * @param id the id
	 * @param description the description
	 * @param status the status
	 * @param plannedStartTime the planned start time
	 * @param estimatedEndTime the estimated end time
	 * @param version the version
	 */
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
	
	
	
	/**
	 * Instantiates a new study.
	 *
	 * @param id the id
	 * @param patient the patient
	 * @param description the description
	 * @param status the status
	 * @param plannedStartTime the planned start time
	 * @param estimatedEndTime the estimated end time
	 * @param version the version
	 * @param schedule the schedule
	 */
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
	
	/**
	 * Instantiates a new study.
	 */
	public Study() {
		super();
	} 
		
}

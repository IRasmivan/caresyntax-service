package com.rasmivan.caresyntax.dto;

import java.time.Instant;

/**
 * The Class StudyDto.
 */
public class StudyDto {

	/** The id. */
	private Long id;
	
	/** The patient. */
	private Long patient;
	
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
	 * Gets the patient.
	 *
	 * @return the patient
	 */
	public Long getPatient() {
		return patient;
	}
	
	/**
	 * Sets the patient.
	 *
	 * @param patient the new patient
	 */
	public void setPatient(Long patient) {
		this.patient = patient;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
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
	 * Gets the version.
	 *
	 * @return the version
	 */
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
	 * Instantiates a new study dto.
	 *
	 * @param id the id
	 * @param patient the patient
	 * @param description the description
	 * @param status the status
	 * @param plannedStartTime the planned start time
	 * @param estimatedEndTime the estimated end time
	 * @param version the version
	 */
	public StudyDto(Long id, Long patient, String description, String status, Instant plannedStartTime,
			Instant estimatedEndTime, Long version) {
		super();
		this.id = id;
		this.patient = patient;
		this.description = description;
		this.status = status;
		this.plannedStartTime = plannedStartTime;
		this.estimatedEndTime = estimatedEndTime;
		this.version = version;
	}
	
	
	
}

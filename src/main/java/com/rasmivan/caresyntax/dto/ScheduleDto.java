package com.rasmivan.caresyntax.dto;

import java.time.Instant;

/**
 * The Class ScheduleDto.
 */
public class ScheduleDto {

	/** The id. */
	private Long id;
	
	/** The study. */
	private Long study;
	
	/** The doctor. */
	private Long doctor;
	
	/** The room. */
	private Long room;
	
	/** The patient. */
	private Long patient;
	
	/** The version. */
	private Long version;
	
	/** The planned start time. */
	private Instant plannedStartTime;
	
	/** The estimated end time. */
	private Instant estimatedEndTime;
	
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
	 * Gets the study.
	 *
	 * @return the study
	 */
	public Long getStudy() {
		return study;
	}
	
	/**
	 * Sets the study.
	 *
	 * @param study the new study
	 */
	public void setStudy(Long study) {
		this.study = study;
	}
	
	/**
	 * Gets the doctor.
	 *
	 * @return the doctor
	 */
	public Long getDoctor() {
		return doctor;
	}
	
	/**
	 * Sets the doctor.
	 *
	 * @param doctor the new doctor
	 */
	public void setDoctor(Long doctor) {
		this.doctor = doctor;
	}
	
	/**
	 * Gets the room.
	 *
	 * @return the room
	 */
	public Long getRoom() {
		return room;
	}
	
	/**
	 * Sets the room.
	 *
	 * @param room the new room
	 */
	public void setRoom(Long room) {
		this.room = room;
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
	 * Instantiates a new schedule dto.
	 *
	 * @param id the id
	 * @param study the study
	 * @param doctor the doctor
	 * @param room the room
	 * @param version the version
	 * @param plannedStartTime the planned start time
	 * @param estimatedEndTime the estimated end time
	 */
	public ScheduleDto(Long id, Long study, Long doctor, Long room, Long version, Instant plannedStartTime, Instant estimatedEndTime) {
		super();
		this.id = id;
		this.study = study;
		this.doctor = doctor;
		this.room = room;
		this.version = version;
		this.plannedStartTime = plannedStartTime;
		this.estimatedEndTime = estimatedEndTime;
		
	}
	
	
}

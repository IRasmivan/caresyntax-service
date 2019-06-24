package com.rasmivan.caresyntax.dto;

import java.time.Instant;

public class StudyDto {

	private Long id;
	private Long patient;
	private String description;
	private String status;
	private Instant plannedStartTime;
	private Instant estimatedEndTime;
	private Long version;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPatient() {
		return patient;
	}
	public void setPatient(Long patient) {
		this.patient = patient;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Instant getPlannedStartTime() {
		return plannedStartTime;
	}
	public void setPlannedStartTime(Instant plannedStartTime) {
		this.plannedStartTime = plannedStartTime;
	}
	public Instant getEstimatedEndTime() {
		return estimatedEndTime;
	}
	public void setEstimatedEndTime(Instant estimatedEndTime) {
		this.estimatedEndTime = estimatedEndTime;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
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

package com.rasmivan.caresyntax.dto;

import java.time.Instant;

public class ScheduleDto {

	private Long id;
	private Long study;
	private Long doctor;
	private Long room;
	private Long patient;
	private Long version;
	private Instant plannedStartTime;
	private Instant estimatedEndTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStudy() {
		return study;
	}
	public void setStudy(Long study) {
		this.study = study;
	}
	public Long getDoctor() {
		return doctor;
	}
	public void setDoctor(Long doctor) {
		this.doctor = doctor;
	}
	public Long getRoom() {
		return room;
	}
	public void setRoom(Long room) {
		this.room = room;
	}
	public Long getPatient() {
		return patient;
	}
	public void setPatient(Long patient) {
		this.patient = patient;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
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

package com.rasmivan.caresyntax.domain;

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

@Entity
@Table(name = "schedule")
public class Schedule {

	private Long id;
	private Study study;
	private Doctor doctor;
	private Room room;
	
	private Long version;
	
	private Long studytId;
	private String studyStatus;
	private Long doctortId;
	private String doctorName;
	private Long roomtId;
	private String roomName;
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
	@JoinColumn(name = "study", nullable = false)
	@JsonBackReference
	public Study getStudy() {
		return study;
	}
	public void setStudy(Study study) {
		this.study = study;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor", nullable = false)
	@JsonBackReference
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room", nullable = false)
	@JsonBackReference
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	@Version
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	public Long getStudytId() {
		return study.getId();
	}
	public void setStudytId(Long studytId) {
		this.studytId = studytId;
	}
	public String getStudyStatus() {
		return study.getStatus();
	}
	public void setStudyStatus(String studyStatus) {
		this.studyStatus = studyStatus;
	}
	public Long getDoctortId() {
		return doctor.getId();
	}
	public void setDoctortId(Long doctortId) {
		this.doctortId = doctortId;
	}
	public String getDoctorName() {
		return doctor.getName();
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Long getRoomtId() {
		return room.getId();
	}
	public void setRoomtId(Long roomtId) {
		this.roomtId = roomtId;
	}
	public String getRoomName() {
		return room.getName();
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Long getPatientId() {
		return study.getPatientId();
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return study.getPatientName();
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Schedule(Long id, Study study, Doctor doctor, Room room, Long version) {
		super();
		this.id = id;
		this.study = study;
		this.doctor = doctor;
		this.room = room;
		this.version = version;
	}
	public Schedule() {
		super();
	} 
	
}

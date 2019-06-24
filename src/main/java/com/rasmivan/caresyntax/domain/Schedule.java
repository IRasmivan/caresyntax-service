package com.rasmivan.caresyntax.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The Class Schedule.
 */
@Entity
@Table(name = "schedule")
public class Schedule {

	/** The id. */
	private Long id;
	
	/** The study. */
	private Study study;
	
	/** The doctor. */
	private Doctor doctor;
	
	/** The room. */
	private Room room;
	
	/** The version. */
	private Long version;
	
	/** The studyt id. */
	private Long studytId;
	
	/** The study status. */
	private String studyStatus;
	
	/** The doctort id. */
	private Long doctortId;
	
	/** The doctor name. */
	private String doctorName;
	
	/** The roomt id. */
	private Long roomtId;
	
	/** The room name. */
	private String roomName;
	
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
	 * Gets the study.
	 *
	 * @return the study
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "study", nullable = false)
	@JsonBackReference
	public Study getStudy() {
		return study;
	}
	
	/**
	 * Sets the study.
	 *
	 * @param study the new study
	 */
	public void setStudy(Study study) {
		this.study = study;
	}
	
	/**
	 * Gets the doctor.
	 *
	 * @return the doctor
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor", nullable = false)
	@JsonBackReference
	public Doctor getDoctor() {
		return doctor;
	}
	
	/**
	 * Sets the doctor.
	 *
	 * @param doctor the new doctor
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	/**
	 * Gets the room.
	 *
	 * @return the room
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room", nullable = false)
	@JsonBackReference
	public Room getRoom() {
		return room;
	}
	
	/**
	 * Sets the room.
	 *
	 * @param room the new room
	 */
	public void setRoom(Room room) {
		this.room = room;
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
	 * Gets the studyt id.
	 *
	 * @return the studyt id
	 */
	public Long getStudytId() {
		return study.getId();
	}
	
	/**
	 * Sets the studyt id.
	 *
	 * @param studytId the new studyt id
	 */
	public void setStudytId(Long studytId) {
		this.studytId = studytId;
	}
	
	/**
	 * Gets the study status.
	 *
	 * @return the study status
	 */
	public String getStudyStatus() {
		return study.getStatus();
	}
	
	/**
	 * Sets the study status.
	 *
	 * @param studyStatus the new study status
	 */
	public void setStudyStatus(String studyStatus) {
		this.studyStatus = studyStatus;
	}
	
	/**
	 * Gets the doctort id.
	 *
	 * @return the doctort id
	 */
	public Long getDoctortId() {
		return doctor.getId();
	}
	
	/**
	 * Sets the doctort id.
	 *
	 * @param doctortId the new doctort id
	 */
	public void setDoctortId(Long doctortId) {
		this.doctortId = doctortId;
	}
	
	/**
	 * Gets the doctor name.
	 *
	 * @return the doctor name
	 */
	public String getDoctorName() {
		return doctor.getName();
	}
	
	/**
	 * Sets the doctor name.
	 *
	 * @param doctorName the new doctor name
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	/**
	 * Gets the roomt id.
	 *
	 * @return the roomt id
	 */
	public Long getRoomtId() {
		return room.getId();
	}
	
	/**
	 * Sets the roomt id.
	 *
	 * @param roomtId the new roomt id
	 */
	public void setRoomtId(Long roomtId) {
		this.roomtId = roomtId;
	}
	
	/**
	 * Gets the room name.
	 *
	 * @return the room name
	 */
	public String getRoomName() {
		return room.getName();
	}
	
	/**
	 * Sets the room name.
	 *
	 * @param roomName the new room name
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	/**
	 * Gets the patient id.
	 *
	 * @return the patient id
	 */
	public Long getPatientId() {
		return study.getPatientId();
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
		return study.getPatientName();
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
	 * Instantiates a new schedule.
	 *
	 * @param id the id
	 * @param study the study
	 * @param doctor the doctor
	 * @param room the room
	 * @param version the version
	 */
	public Schedule(Long id, Study study, Doctor doctor, Room room, Long version) {
		super();
		this.id = id;
		this.study = study;
		this.doctor = doctor;
		this.room = room;
		this.version = version;
	}
	
	/**
	 * Instantiates a new schedule.
	 */
	public Schedule() {
		super();
	} 
	
}

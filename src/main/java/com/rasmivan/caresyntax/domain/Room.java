package com.rasmivan.caresyntax.domain;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The Class Room.
 */
@Entity
@Table(name = "room")
public class Room {

	/** The id. */
	private Long id;
	
	/** The name. */
	private String name;
	
	/** The version. */
	private Long version;
	
	/** The schedule. */
	private Set<Schedule> schedule = new TreeSet<>();
	
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
	 * Gets the schedule.
	 *
	 * @return the schedule
	 */
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "room")
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
}

package com.rasmivan.caresyntax.service;

import org.springframework.data.domain.Page;

import com.rasmivan.caresyntax.domain.Doctor;
import com.rasmivan.caresyntax.dto.DoctorDto;

/**
 * The Interface DoctorService.
 */
public interface DoctorService {
	
	/**
	 * Gets the all doctors.
	 *
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the all doctors
	 */
	Page<Doctor> getAllDoctors(int pageNumber, int pageSize);
	
	/**
	 * Adds the doctor.
	 *
	 * @param doctorDto the doctor dto
	 * @return the doctor
	 */
	Doctor addDoctor(DoctorDto doctorDto);
	
}

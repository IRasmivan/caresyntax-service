package com.rasmivan.caresyntax.service;


import org.springframework.data.domain.Page;

import com.rasmivan.caresyntax.domain.Patient;
import com.rasmivan.caresyntax.dto.PatientDto;

/**
 * The Interface PatientService.
 */
public interface PatientService {
	
	/**
	 * Gets the all patient.
	 *
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the all patient
	 */
	Page<Patient> getAllPatient(int pageNumber, int pageSize);
	
	/**
	 * Adds the patient.
	 *
	 * @param patientDto the patient dto
	 * @return the patient
	 */
	Patient addPatient(PatientDto patientDto);
	
	/**
	 * Update patient.
	 *
	 * @param patientDto the patient dto
	 * @return the patient
	 */
	Patient updatePatient(PatientDto patientDto);
	
	/**
	 * Delete patient.
	 *
	 * @param patientDto the patient dto
	 * @return the string
	 */
	String deletePatient(PatientDto patientDto);

	/**
	 * Validate patient exists.
	 *
	 * @param patientId the patient id
	 * @return true, if successful
	 */
	boolean validatePatientExists(Long patientId);

	/**
	 * Gets the product by patient name.
	 *
	 * @param patientName the patient name
	 * @return the product by patient name
	 */
	Patient getProductByPatientName(String patientName);

}

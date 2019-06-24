package com.rasmivan.caresyntax.service;


import org.springframework.data.domain.Page;

import com.rasmivan.caresyntax.domain.Patient;
import com.rasmivan.caresyntax.dto.PatientDto;

public interface PatientService {
	
	Page<Patient> getAllPatient(int pageNumber, int pageSize);
	
	Patient addPatient(PatientDto patientDto);
	
	Patient updatePatient(PatientDto patientDto);
	
	String deletePatient(PatientDto patientDto);

	boolean validatePatientExists(Long patientId);

	Patient getProductByPatientName(String patientName);

}

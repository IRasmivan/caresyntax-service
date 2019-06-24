package com.rasmivan.caresyntax.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rasmivan.caresyntax.constants.MessageConstantsUtils;
import com.rasmivan.caresyntax.domain.Patient;
import com.rasmivan.caresyntax.dto.PatientDto;
import com.rasmivan.caresyntax.exception.InvalidPatientDetails;
import com.rasmivan.caresyntax.exception.PatientStudyNotFound;
import com.rasmivan.caresyntax.helper.CommonValidationUtils;
import com.rasmivan.caresyntax.helper.PatientPredicateUtils;
import com.rasmivan.caresyntax.repository.PatientRepository;

/**
 * The Class PatientServiceImp.
 */
@Service
public class PatientServiceImp implements PatientService {

	/** The patient repository. */
	@Autowired
	PatientRepository patientRepository;
	
	/** The patient predicate utils. */
	@Autowired
	PatientPredicateUtils patientPredicateUtils;
	
	/** The common validation utils. */
	@Autowired
	CommonValidationUtils commonValidationUtils;
	
	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.PatientService#getAllPatient(int, int)
	 */
	@Override
	public Page<Patient> getAllPatient(int pageNumber, int pageSize) {
		commonValidationUtils.validatePageSizeAndPageNumber(pageNumber, pageSize);
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return patientRepository.findAll(pageable);
	}
	
	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.PatientService#getProductByPatientName(java.lang.String)
	 */
	@Override
	public Patient getProductByPatientName(String patientName) {
		if(patientName != null) {
			Patient patient = patientRepository.getbyPatientName(patientName);
			if (patient != null && patient.getId() != null) {
				return patient;
			} else {
				 throw new PatientStudyNotFound(MessageConstantsUtils.INVALID_PATIENT_DOES_NOT_EXISTS + " - " +  patientName);
			}
		} else {
			throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_DETAILS);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.PatientService#addPatient(com.rasmivan.caresyntax.dto.PatientDto)
	 */
	@Override
	public Patient addPatient(PatientDto patientDto) {
		validatePatientDto(patientDto);
		return patientRepository.save(convertDtoToDomain(patientDto));
	}

	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.PatientService#updatePatient(com.rasmivan.caresyntax.dto.PatientDto)
	 */
	@Override
	public Patient updatePatient(PatientDto patientDto) {
		validatePatientForUpdate(patientDto);
		Patient patient = convertDtoToDomain(patientDto);
		Optional<Patient> pat = patientRepository.findById(patient.getId());
		if(pat.isPresent()) { 
			BeanUtils.copyProperties(pat, patient);
			patient.setVersion(pat.get().getVersion());
		}
		return patientRepository.save(patient);
	}

	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.PatientService#deletePatient(com.rasmivan.caresyntax.dto.PatientDto)
	 */
	@Override
	public String deletePatient(PatientDto patientDto) {
		if(patientDto != null) { 
			validatePatientExists(patientDto.getId());
		} else {
			throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_DETAILS);
		}
		patientRepository.delete(convertDtoToDomain(patientDto));
		return MessageConstantsUtils.DELETED_SUCCESSFULLY;
	}

	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.PatientService#validatePatientExists(java.lang.Long)
	 */
	@Override
	public boolean validatePatientExists(Long patientId) {
		if(patientId != null) {
			if(!patientRepository.existsById(patientId)) {
				throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_DOES_NOT_EXISTS);
			}
		}  else {
			throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_DETAILS);
		}
		return true;
	}
	
	/**
	 * Convert dto to domain.
	 *
	 * @param patientDto the patient dto
	 * @return the patient
	 */
	private Patient convertDtoToDomain(PatientDto patientDto) {
		Patient patient = new Patient();
		BeanUtils.copyProperties(patientDto, patient);
		return patient;
	}
	
	/**
	 * Validate patient dto.
	 *
	 * @param patientDto the patient dto
	 */
	private void validatePatientDto(PatientDto patientDto) {
		if(patientDto != null) {
			if(patientPredicateUtils.checkIfValidPatientName(patientDto)) { // Check if the Patient Name is valid is not NULL
				throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_NAME);
			}
			
			if(patientPredicateUtils.checkIfValidPatientSex(patientDto))  { // Check if the patient have provided valid Sex
				throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_SEX);
			}
			
			if(patientPredicateUtils.checkIfValidPatientDob(patientDto)){ // Check if the patient have provided valid DOB
				throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_DOB);
			}
		} else {
			throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_DETAILS);
		}
	}
	
	/**
	 * Validate patient for update.
	 *
	 * @param patientDto the patient dto
	 */
	private void validatePatientForUpdate(PatientDto patientDto) {
		validatePatientDto(patientDto);
		validatePatientExists(patientDto.getId());
		
	}
	
}
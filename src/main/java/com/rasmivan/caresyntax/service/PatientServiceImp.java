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

@Service
public class PatientServiceImp implements PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	PatientPredicateUtils patientPredicateUtils;
	
	@Autowired
	CommonValidationUtils commonValidationUtils;
	
	@Override
	public Page<Patient> getAllPatient(int pageNumber, int pageSize) {
		commonValidationUtils.validatePageSizeAndPageNumber(pageNumber, pageSize);
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return patientRepository.findAll(pageable);
	}
	
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
	
	@Override
	public Patient addPatient(PatientDto patientDto) {
		validatePatientDto(patientDto);
		return patientRepository.save(convertDtoToDomain(patientDto));
	}

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
	
	private Patient convertDtoToDomain(PatientDto patientDto) {
		Patient patient = new Patient();
		BeanUtils.copyProperties(patientDto, patient);
		return patient;
	}
	
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
	
	private void validatePatientForUpdate(PatientDto patientDto) {
		validatePatientDto(patientDto);
		validatePatientExists(patientDto.getId());
		
	}
	
}
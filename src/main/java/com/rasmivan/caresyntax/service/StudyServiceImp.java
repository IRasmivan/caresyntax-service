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
import com.rasmivan.caresyntax.domain.Study;
import com.rasmivan.caresyntax.dto.StudyDto;
import com.rasmivan.caresyntax.exception.InvalidPatientDetails;
import com.rasmivan.caresyntax.exception.InvalidStudyDetails;
import com.rasmivan.caresyntax.exception.PatientStudyNotFound;
import com.rasmivan.caresyntax.helper.CommonValidationUtils;
import com.rasmivan.caresyntax.helper.StudyPredicateUtils;
import com.rasmivan.caresyntax.repository.PatientRepository;
import com.rasmivan.caresyntax.repository.StudyRepository;

/**
 * The Class StudyServiceImp.
 */
@Service
public class StudyServiceImp implements StudyService {
	
	/** The common validation utils. */
	@Autowired
	CommonValidationUtils commonValidationUtils;
	
	/** The study repository. */
	@Autowired
	StudyRepository studyRepository;
	
	/** The study predicate utils. */
	@Autowired
	StudyPredicateUtils studyPredicateUtils;
	
	/** The patient repository. */
	@Autowired
	PatientRepository patientRepository;

	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.StudyService#getAllStudy(int, int)
	 */
	@Override
	public Page<Study> getAllStudy(int pageNumber, int pageSize) {
		commonValidationUtils.validatePageSizeAndPageNumber(pageNumber, pageSize);
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return studyRepository.findAll(pageable);
	}
	
	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.StudyService#getStudyByPatientId(java.lang.Long)
	 */
	@Override
	public Study getStudyByPatientId(Long patientId) {
		if(patientId != null) {
			Study study = studyRepository.getStudyByPatientId(patientId);
			if (study != null && study.getId() != null) {
				return study;
			} else {
				 throw new PatientStudyNotFound(MessageConstantsUtils.STUDY_NOT_FOUND_FOR_PATIENT + patientId);
			}
		} else {
			throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_DETAILS);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.StudyService#getStudyByPatientName(java.lang.String)
	 */
	@Override
	public StudyDto getStudyByPatientName(String patientName) {
		if(patientName != null) {
			StudyDto study = studyRepository.getStudyByPatientName(patientName);
			if (study != null && study.getId() != null) {
				return study;
			} else {
				 throw new PatientStudyNotFound(MessageConstantsUtils.STUDY_NOT_FOUND_FOR_PATIENT + patientName);
			}
		} else {
			throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_DETAILS);
		}
	}

	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.StudyService#addStudy(com.rasmivan.caresyntax.dto.StudyDto)
	 */
	@Override
	public Study addStudy(StudyDto studyDto) {
		Study study = new Study();
		validateStudyDto(studyDto);
		BeanUtils.copyProperties(studyDto, study);
		getPatientDetails(studyDto, study);
		return studyRepository.save(study);
	}

	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.StudyService#updateStudy(com.rasmivan.caresyntax.dto.StudyDto)
	 */
	@Override
	public Study updateStudy(StudyDto studyDto) {
		Study study = new Study();
		validateStudyDto(studyDto);
		validateStudyExists(studyDto.getId());
		BeanUtils.copyProperties(studyDto, study);
		getPatientDetails(studyDto, study);
		return studyRepository.save(study);
	}
	
	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.StudyService#validateStudyExists(java.lang.Long)
	 */
	@Override
	public boolean validateStudyExists(Long studyId) {
		if(studyId != null) {
			if(!studyRepository.existsById(studyId)) {
				throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_DOES_NOT_EXISTS);
			}
		}  else {
			throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_DETAILS);
		}
		return true;
	}
	
	/**
	 * Validate study dto.
	 *
	 * @param studyDto the study dto
	 */
	private void validateStudyDto(StudyDto studyDto) {
		if(studyDto != null) {
			if(studyPredicateUtils.checkIfValidPatient(studyDto)) {
				throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_DOES_NOT_EXISTS);
			}
			
			if(studyPredicateUtils.checkIfValidDescription(studyDto)) {
				throw new InvalidStudyDetails(MessageConstantsUtils.INVALID_STUDY_DESCRIPTION);
			}
			
			if(!studyPredicateUtils.checkIfValidStatus(studyDto)) {
				throw new InvalidStudyDetails(MessageConstantsUtils.INVALID_STUDY_STATUS);
			}
			
			if(studyDto.getPlannedStartTime() == null) {
				throw new InvalidStudyDetails(MessageConstantsUtils.INVALID_STUDY_PLANNED_START);
			}
		} else {
			throw new InvalidStudyDetails(MessageConstantsUtils.INVALID_STUDY_DETAILS);
		}
	}
	
	
	/**
	 * Gets the patient details.
	 *
	 * @param studyDto the study dto
	 * @param study the study
	 * @return the patient details
	 */
	private void getPatientDetails(StudyDto studyDto, Study study) {
		Optional<Patient> patient = patientRepository.findById(studyDto.getPatient());
		if(patient.isPresent()) {
			study.setPatient(patient.get());
		} else {
			throw new InvalidPatientDetails(MessageConstantsUtils.INVALID_PATIENT_DOES_NOT_EXISTS);
		}
	}

}

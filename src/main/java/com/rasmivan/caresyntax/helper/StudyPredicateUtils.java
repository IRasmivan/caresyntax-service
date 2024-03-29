package com.rasmivan.caresyntax.helper;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rasmivan.caresyntax.constants.GeneralConstantsUtils;
import com.rasmivan.caresyntax.dto.StudyDto;
import com.rasmivan.caresyntax.service.PatientService;


/**
 * The Class StudyPredicateUtils.
 */
@Component
public class StudyPredicateUtils {
	
	/** The patient service. */
	@Autowired
	PatientService patientService;
	
	/**
	 * Check if valid patient.
	 *
	 * @param study the study
	 * @return true, if successful
	 */
	public boolean checkIfValidPatient(StudyDto study) {
		Predicate<StudyDto> studyPredicate =  studyDto -> 
													(studyDto.getPatient() == null) || 
													(studyDto.getPatient() != null && 
														!patientService.validatePatientExists(studyDto.getPatient()));
		return studyPredicate.test(study);
	}
	
	/**
	 * Check if valid description.
	 *
	 * @param study the study
	 * @return true, if successful
	 */
	public boolean checkIfValidDescription(StudyDto study) {
		Predicate<StudyDto> studyPredicate =  studyDto -> 
													(studyDto.getDescription() == null || 
													(studyDto.getDescription() != null && 
															studyDto.getDescription().equals(GeneralConstantsUtils.EMPTY_STRING)));
		return studyPredicate.test(study);
	}
	
	
	/**
	 * Check if valid status.
	 *
	 * @param study the study
	 * @return true, if successful
	 */
	public boolean checkIfValidStatus(StudyDto study) {
		Predicate<StudyDto> studyPredicate =  studyDto -> 
													(studyDto.getStatus() != null && (
															   studyDto.getStatus().equals(GeneralConstantsUtils.EMPTY_STRING)
															|| studyDto.getStatus().equalsIgnoreCase(GeneralConstantsUtils.STUDY_STATUS_PLANNED)
															|| studyDto.getStatus().equalsIgnoreCase(GeneralConstantsUtils.STUDY_STATUS_IN_PROGRESS)
															|| studyDto.getStatus().equalsIgnoreCase(GeneralConstantsUtils.STUDY_STATUS_FINISHED)));
		return studyPredicate.test(study);
	}
	

}
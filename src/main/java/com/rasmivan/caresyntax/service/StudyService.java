package com.rasmivan.caresyntax.service;

import org.springframework.data.domain.Page;

import com.rasmivan.caresyntax.domain.Study;
import com.rasmivan.caresyntax.dto.StudyDto;

/**
 * The Interface StudyService.
 */
public interface StudyService {
	
	/**
	 * Gets the all study.
	 *
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the all study
	 */
	Page<Study> getAllStudy(int pageNumber, int pageSize);

	/**
	 * Gets the study by patient id.
	 *
	 * @param patientId the patient id
	 * @return the study by patient id
	 */
	Study getStudyByPatientId(Long patientId);
	
	/**
	 * Adds the study.
	 *
	 * @param studyDto the study dto
	 * @return the study
	 */
	Study addStudy(StudyDto studyDto);
	
	/**
	 * Update study.
	 *
	 * @param studyDto the study dto
	 * @return the study
	 */
	Study updateStudy(StudyDto studyDto);

	/**
	 * Validate study exists.
	 *
	 * @param studyId the study id
	 * @return true, if successful
	 */
	boolean validateStudyExists(Long studyId);

	/**
	 * Gets the study by patient name.
	 *
	 * @param patientName the patient name
	 * @return the study by patient name
	 */
	StudyDto getStudyByPatientName(String patientName);
	
}
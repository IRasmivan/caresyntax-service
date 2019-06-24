package com.rasmivan.caresyntax.service;

import org.springframework.data.domain.Page;

import com.rasmivan.caresyntax.domain.Study;
import com.rasmivan.caresyntax.dto.StudyDto;

public interface StudyService {
	
	Page<Study> getAllStudy(int pageNumber, int pageSize);

	Study getStudyByPatientId(Long patientId);
	
	Study addStudy(StudyDto studyDto);
	
	Study updateStudy(StudyDto studyDto);

	boolean validateStudyExists(Long studyId);

	StudyDto getStudyByPatientName(String patientName);
	
}
package com.rasmivan.caresyntax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rasmivan.caresyntax.domain.Study;
import com.rasmivan.caresyntax.dto.StudyDto;
import com.rasmivan.caresyntax.service.StudyService;

/**
 * The Class StudyController.
 */
@RestController
@CrossOrigin
@RequestMapping("/caresyntax/api")
public class StudyController {
	
	/** The study service. */
	@Autowired
	StudyService studyService;
	
	/**
	 * Gets the all studys.
	 *
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the all studys
	 */
	@GetMapping(value = "/v1/studys")
	public ResponseEntity<Page<Study>> getAllStudys(@RequestParam int pageNumber,@RequestParam int pageSize){
		return new ResponseEntity<>(studyService.getAllStudy(pageNumber, pageSize), HttpStatus.OK);
	}
	
	/**
	 * Gets the study by patient name.
	 *
	 * @param patientName the patient name
	 * @return the study by patient name
	 */
	@GetMapping(value = "/v1/studyByPatientName")
	public ResponseEntity<StudyDto> getStudyByPatientName(@RequestParam String patientName){
		return new ResponseEntity<>(studyService.getStudyByPatientName(patientName), HttpStatus.OK);
	}

	
	/**
	 * Gets the study by patient id.
	 *
	 * @param patientId the patient id
	 * @return the study by patient id
	 */
	@GetMapping(value = "/v1/study")
	public ResponseEntity<Study> getStudyByPatientId(@RequestParam Long patientId){
		return new ResponseEntity<>(studyService.getStudyByPatientId(patientId), HttpStatus.OK);
	}
	
	/**
	 * Adds the products.
	 *
	 * @param studyDto the study dto
	 * @return the response entity
	 */
	@PostMapping(value = "/v1/study/add")
	public ResponseEntity<Study> addProducts(@RequestBody StudyDto studyDto){
		return new ResponseEntity<>(studyService.addStudy(studyDto), HttpStatus.CREATED);
	}
	
	/**
	 * Update products.
	 *
	 * @param studyDto the study dto
	 * @return the response entity
	 */
	@PutMapping(value = "/v1/study/update")
	public ResponseEntity<Study> updateProducts(@RequestBody StudyDto studyDto){
		return new ResponseEntity<>(studyService.updateStudy(studyDto), HttpStatus.CREATED);
	}
}

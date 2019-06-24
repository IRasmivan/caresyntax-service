package com.rasmivan.caresyntax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rasmivan.caresyntax.domain.Patient;
import com.rasmivan.caresyntax.dto.PatientDto;
import com.rasmivan.caresyntax.service.PatientService;

/**
 * The Class PatientController.
 */
@RestController
@CrossOrigin
@RequestMapping("/caresyntax/api")
public class PatientController {
	
	/** The patient service. */
	@Autowired
	PatientService patientService;
	
	/**
	 * Gets the all products.
	 *
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the all products
	 */
	@GetMapping(value = "/v1/patients")
	public ResponseEntity<Page<Patient>> getAllProducts(@RequestParam int pageNumber,@RequestParam int pageSize){
		return new ResponseEntity<>(patientService.getAllPatient(pageNumber, pageSize), HttpStatus.OK);
	}
	
	/**
	 * Gets the product by patient name.
	 *
	 * @param patientName the patient name
	 * @return the product by patient name
	 */
	@GetMapping(value = "/v1/patient")
	public ResponseEntity<Patient> getProductByPatientName(@RequestParam String patientName){
		return new ResponseEntity<>(patientService.getProductByPatientName(patientName), HttpStatus.OK);
	}
	
	/**
	 * Adds the products.
	 *
	 * @param patientDto the patient dto
	 * @return the response entity
	 */
	@PostMapping(value = "/v1/patient/add")
	public ResponseEntity<Patient> addProducts(@RequestBody PatientDto patientDto){
		return new ResponseEntity<>(patientService.addPatient(patientDto), HttpStatus.CREATED);
	}
	
	/**
	 * Update products.
	 *
	 * @param patientDto the patient dto
	 * @return the response entity
	 */
	@PutMapping(value = "/v1/patient/update")
	public ResponseEntity<Patient> updateProducts(@RequestBody PatientDto patientDto){
		return new ResponseEntity<>(patientService.updatePatient(patientDto), HttpStatus.OK);
	}
	
	/**
	 * Delete products.
	 *
	 * @param patientDto the patient dto
	 * @return the response entity
	 */
	@DeleteMapping(value = "/v1/patient/delete")
	public ResponseEntity<Patient> deleteProducts(@RequestBody PatientDto patientDto){
		return new ResponseEntity<>(patientService.updatePatient(patientDto), HttpStatus.OK);
	}

}

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

@RestController
@CrossOrigin
@RequestMapping("/caresyntax/api")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping(value = "/v1/patients")
	public ResponseEntity<Page<Patient>> getAllProducts(@RequestParam int pageNumber,@RequestParam int pageSize){
		return new ResponseEntity<>(patientService.getAllPatient(pageNumber, pageSize), HttpStatus.OK);
	}
	
	@GetMapping(value = "/v1/patient")
	public ResponseEntity<Patient> getProductByPatientName(@RequestParam String patientName){
		return new ResponseEntity<>(patientService.getProductByPatientName(patientName), HttpStatus.OK);
	}
	
	@PostMapping(value = "/v1/patient/add")
	public ResponseEntity<Patient> addProducts(@RequestBody PatientDto patientDto){
		return new ResponseEntity<>(patientService.addPatient(patientDto), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/v1/patient/update")
	public ResponseEntity<Patient> updateProducts(@RequestBody PatientDto patientDto){
		return new ResponseEntity<>(patientService.updatePatient(patientDto), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/v1/patient/delete")
	public ResponseEntity<Patient> deleteProducts(@RequestBody PatientDto patientDto){
		return new ResponseEntity<>(patientService.updatePatient(patientDto), HttpStatus.OK);
	}

}

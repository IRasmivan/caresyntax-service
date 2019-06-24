package com.rasmivan.caresyntax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rasmivan.caresyntax.domain.Doctor;
import com.rasmivan.caresyntax.dto.DoctorDto;
import com.rasmivan.caresyntax.service.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/caresyntax/api")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;

	@GetMapping(value = "/v1/doctors")
	public ResponseEntity<Page<Doctor>> getAllProducts(@RequestParam int pageNumber,@RequestParam int pageSize){
		return new ResponseEntity<>(doctorService.getAllDoctors(pageNumber, pageSize), HttpStatus.OK);
	}
	
	@PostMapping(value = "/v1/doctor/add")
	public ResponseEntity<Doctor> addProducts(@RequestBody DoctorDto doctorDto){
		return new ResponseEntity<>(doctorService.addDoctor(doctorDto), HttpStatus.CREATED);
	}
}

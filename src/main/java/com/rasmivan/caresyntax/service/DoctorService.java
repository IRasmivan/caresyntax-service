package com.rasmivan.caresyntax.service;

import org.springframework.data.domain.Page;

import com.rasmivan.caresyntax.domain.Doctor;
import com.rasmivan.caresyntax.dto.DoctorDto;

public interface DoctorService {
	
	Page<Doctor> getAllDoctors(int pageNumber, int pageSize);
	
	Doctor addDoctor(DoctorDto doctorDto);
	
}

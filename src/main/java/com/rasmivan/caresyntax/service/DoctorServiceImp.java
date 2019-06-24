package com.rasmivan.caresyntax.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rasmivan.caresyntax.domain.Doctor;
import com.rasmivan.caresyntax.dto.DoctorDto;
import com.rasmivan.caresyntax.helper.CommonValidationUtils;
import com.rasmivan.caresyntax.repository.DoctorRepository;

/**
 * The Class DoctorServiceImp.
 */
@Service
public class DoctorServiceImp implements DoctorService {
	
	/** The common validation utils. */
	@Autowired
	CommonValidationUtils commonValidationUtils;
	
	/** The doctor repository. */
	@Autowired
	DoctorRepository doctorRepository;

	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.DoctorService#getAllDoctors(int, int)
	 */
	@Override
	public Page<Doctor> getAllDoctors(int pageNumber, int pageSize) {
		commonValidationUtils.validatePageSizeAndPageNumber(pageNumber, pageSize);
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return doctorRepository.findAll(pageable);
	}

	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.DoctorService#addDoctor(com.rasmivan.caresyntax.dto.DoctorDto)
	 */
	@Override
	public Doctor addDoctor(DoctorDto doctorDto) {
		Doctor doctor = new Doctor();
		BeanUtils.copyProperties(doctorDto, doctor);
		return doctorRepository.save(doctor);
	}
	
}

package com.rasmivan.caresyntax.helper;

import java.time.Instant;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

import com.rasmivan.caresyntax.constants.GeneralConstantsUtils;
import com.rasmivan.caresyntax.dto.PatientDto;


@Component
public class PatientPredicateUtils {
	
	public boolean checkIfValidPatientName(PatientDto patient) {
		Predicate<PatientDto> patientPredicate =  p -> (p.getName() == null || p.getName().isEmpty());
		return patientPredicate.test(patient);
	}
	
	
	public boolean checkIfValidPatientSex(PatientDto patient) {
		Predicate<PatientDto> patientPredicate =  patientDto -> 
					(patientDto.getSex() != null && 
					!patientDto.getSex().isEmpty() && 
						!(patientDto.getSex().equalsIgnoreCase(GeneralConstantsUtils.MALE)
							|| patientDto.getSex().equalsIgnoreCase(GeneralConstantsUtils.FEMALE)
							|| patientDto.getSex().equalsIgnoreCase(GeneralConstantsUtils.OTHER)));
		
		return patientPredicate.test(patient);
	}
	
	public boolean checkIfValidPatientDob(PatientDto patient) {
		Predicate<PatientDto> patientPredicate =  patientDto -> 
										(patientDto.getDateOfBirth() != null && 
											patientDto.getDateOfBirth().isAfter(Instant.now()));
		return patientPredicate.test(patient);
	}

}
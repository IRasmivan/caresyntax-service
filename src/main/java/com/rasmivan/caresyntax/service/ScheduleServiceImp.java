package com.rasmivan.caresyntax.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rasmivan.caresyntax.constants.MessageConstantsUtils;
import com.rasmivan.caresyntax.domain.Doctor;
import com.rasmivan.caresyntax.domain.Patient;
import com.rasmivan.caresyntax.domain.Room;
import com.rasmivan.caresyntax.domain.Schedule;
import com.rasmivan.caresyntax.domain.Study;
import com.rasmivan.caresyntax.dto.ScheduleDto;
import com.rasmivan.caresyntax.exception.InvalidScheduleDetails;
import com.rasmivan.caresyntax.helper.CommonValidationUtils;
import com.rasmivan.caresyntax.repository.DoctorRepository;
import com.rasmivan.caresyntax.repository.PatientRepository;
import com.rasmivan.caresyntax.repository.RoomRepository;
import com.rasmivan.caresyntax.repository.ScheduleRepository;
import com.rasmivan.caresyntax.repository.StudyRepository;

/**
 * The Class ScheduleServiceImp.
 */
@Service
public class ScheduleServiceImp implements ScheduleService {
	
	/** The common validation utils. */
	@Autowired
	CommonValidationUtils commonValidationUtils;
	
	/** The schedule repository. */
	@Autowired
	ScheduleRepository scheduleRepository;
	
	/** The room repository. */
	@Autowired
	RoomRepository roomRepository;
	
	/** The doctor repository. */
	@Autowired
	DoctorRepository doctorRepository;
	
	/** The study repository. */
	@Autowired
	StudyRepository studyRepository;
	
	/** The patient repository. */
	@Autowired
	PatientRepository patientRepository;

	/** (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.ScheduleService#getAllSchedules(int, int)
	 * 
	 * 1) Implemented Pagination
	 * 		1.1) Check if the pageSize is always less then 25 and
	 * 		1.2) Check if the pageNumber is always zero or grater than zero value.
	 * 
	 */
	@Override
	public Page<Schedule> getAllSchedules(int pageNumber, int pageSize) {
		commonValidationUtils.validatePageSizeAndPageNumber(pageNumber, pageSize);
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return scheduleRepository.findAll(pageable);
	}
	
	/** (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.ScheduleService#addSchedule(com.rasmivan.caresyntax.dto.ScheduleDto)
	 * 
	 * 1) Check if the doctor and the study is already available, This is to prevent the same study is schedule twice.
	 * 
	 */
	@Override
	public Schedule addSchedule(ScheduleDto scheduleDto) {
		validateScheduleDto(scheduleDto);
		checkIfScheduleAlreadyExists(scheduleDto);
		return scheduleRepository.save(convertDtoToDomain(scheduleDto));
	}

	/* (non-Javadoc)
	 * @see com.rasmivan.caresyntax.service.ScheduleService#updateSchedule(com.rasmivan.caresyntax.dto.ScheduleDto)
	 */
	@Override
	public Schedule updateSchedule(ScheduleDto scheduleDto) {
		validateScheduleDto(scheduleDto);
		validateForUpdateScheduleDto(scheduleDto);
		return scheduleRepository.save(convertDtoToDomain(scheduleDto));
	}

	/**
	 * Convert dto to domain.
	 *
	 * 1) Validate all the input from the user before converting into Domain.
	 *
	 * @param scheduleDto the schedule dto
	 * @return the schedule
	 */
	private Schedule convertDtoToDomain(ScheduleDto scheduleDto) {
		Schedule schedule = new Schedule();
		
		Optional<Doctor> doctor = doctorRepository.findById(scheduleDto.getDoctor());
		Optional<Room> room = roomRepository.findById(scheduleDto.getRoom());
		Optional<Study> study = studyRepository.findById(scheduleDto.getStudy());
		Optional<Patient> patient = patientRepository.findById(scheduleDto.getPatient());
		
		schedule.setDoctor(doctor.isPresent() ? doctor.get(): null);
		schedule.setRoom(room.isPresent() ? room.get(): null);
		schedule.setStudy(study.isPresent() ? study.get(): null);
		schedule.getStudy().setPatient(patient.isPresent() ? patient.get(): null);
		return schedule;
		
	}

	/**
	 * Validate schedule dto.
	 *
	 * @param scheduleDto the schedule dto
	 */
	private void validateScheduleDto(ScheduleDto scheduleDto) {
		if(scheduleDto != null) {
			if(!roomRepository.existsById(scheduleDto.getRoom())) {
				throw new InvalidScheduleDetails(MessageConstantsUtils.INVALID_ROOM_NUMBER);
			}
			
			if(!doctorRepository.existsById(scheduleDto.getDoctor())) {
				throw new InvalidScheduleDetails(MessageConstantsUtils.INVALID_DOCTOR);
			}
			
			if(!studyRepository.existsById(scheduleDto.getStudy())) {
				throw new InvalidScheduleDetails(MessageConstantsUtils.INVALID_STUDY);
			}
		} else {
			throw new InvalidScheduleDetails(MessageConstantsUtils.INVALID_SCHEDULE);
		}
	}
	
	/**
	 * Validate for update schedule dto.
	 *
	 * @param scheduleDto the schedule dto
	 */
	private void validateForUpdateScheduleDto(ScheduleDto scheduleDto) {
		if(!scheduleRepository.existsById(scheduleDto.getId())) {
			throw new InvalidScheduleDetails(MessageConstantsUtils.INVALID_SCHEDULE);
		}
	}
	
	/**
	 * Check if schedule already exists.
	 *
	 * @param scheduleDto the schedule dto
	 */
	private void checkIfScheduleAlreadyExists(ScheduleDto scheduleDto) {
		if(!scheduleRepository.getscheduleByDoctorIdAndStudyId(scheduleDto.getDoctor(), scheduleDto.getStudy()).isEmpty()) {
			throw new InvalidScheduleDetails(MessageConstantsUtils.SCHEDULE_ALREADY_EXISTS);
		}
	}
	
}

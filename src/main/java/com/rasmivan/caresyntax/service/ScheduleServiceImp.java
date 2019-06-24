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

@Service
public class ScheduleServiceImp implements ScheduleService {
	
	@Autowired
	CommonValidationUtils commonValidationUtils;
	
	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	StudyRepository studyRepository;
	
	@Autowired
	PatientRepository patientRepository;

	@Override
	public Page<Schedule> getAllSchedules(int pageNumber, int pageSize) {
		commonValidationUtils.validatePageSizeAndPageNumber(pageNumber, pageSize);
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return scheduleRepository.findAll(pageable);
	}
	
	@Override
	public Schedule addSchedule(ScheduleDto scheduleDto) {
		validateScheduleDto(scheduleDto);
		checkIfScheduleAlreadyExists(scheduleDto);
		return scheduleRepository.save(convertDtoToDomain(scheduleDto));
	}

	@Override
	public Schedule updateSchedule(ScheduleDto scheduleDto) {
		validateScheduleDto(scheduleDto);
		validateForUpdateScheduleDto(scheduleDto);
		return scheduleRepository.save(convertDtoToDomain(scheduleDto));
	}

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
	
	private void validateForUpdateScheduleDto(ScheduleDto scheduleDto) {
		if(!scheduleRepository.existsById(scheduleDto.getId())) {
			throw new InvalidScheduleDetails(MessageConstantsUtils.INVALID_SCHEDULE);
		}
	}
	
	private void checkIfScheduleAlreadyExists(ScheduleDto scheduleDto) {
		if(!scheduleRepository.getscheduleByDoctorIdAndStudyId(scheduleDto.getDoctor(), scheduleDto.getStudy()).isEmpty()) {
			throw new InvalidScheduleDetails(MessageConstantsUtils.SCHEDULE_ALREADY_EXISTS);
		}
	}
	
}

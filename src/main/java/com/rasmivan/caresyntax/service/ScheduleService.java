package com.rasmivan.caresyntax.service;

import org.springframework.data.domain.Page;

import com.rasmivan.caresyntax.domain.Schedule;
import com.rasmivan.caresyntax.dto.ScheduleDto;

public interface ScheduleService {
	
	public Page<Schedule> getAllSchedules(int pageNumber, int pageSize);
	
	public Schedule addSchedule(ScheduleDto scheduleDto);
	
	public Schedule updateSchedule(ScheduleDto scheduleDto);

}

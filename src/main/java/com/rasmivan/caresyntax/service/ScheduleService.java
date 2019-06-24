package com.rasmivan.caresyntax.service;

import org.springframework.data.domain.Page;

import com.rasmivan.caresyntax.domain.Schedule;
import com.rasmivan.caresyntax.dto.ScheduleDto;

/**
 * The Interface ScheduleService.
 */
public interface ScheduleService {
	
	/**
	 * Gets the all schedules.
	 *
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the all schedules
	 */
	public Page<Schedule> getAllSchedules(int pageNumber, int pageSize);
	
	/**
	 * Adds the schedule.
	 *
	 * @param scheduleDto the schedule dto
	 * @return the schedule
	 */
	public Schedule addSchedule(ScheduleDto scheduleDto);
	
	/**
	 * Update schedule.
	 *
	 * @param scheduleDto the schedule dto
	 * @return the schedule
	 */
	public Schedule updateSchedule(ScheduleDto scheduleDto);

}

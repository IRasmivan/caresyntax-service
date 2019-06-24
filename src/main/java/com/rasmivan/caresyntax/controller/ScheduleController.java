package com.rasmivan.caresyntax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rasmivan.caresyntax.domain.Schedule;
import com.rasmivan.caresyntax.dto.ScheduleDto;
import com.rasmivan.caresyntax.service.ScheduleService;

/**
 * The Class ScheduleController.
 */
@RestController
@CrossOrigin
@RequestMapping("/caresyntax/api")
public class ScheduleController {

	/** The schedule service. */
	@Autowired
	ScheduleService scheduleService;
	
	/**
	 * Gets the all schedules.
	 *
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the all schedules
	 */
	@GetMapping(value = "/v1/schedule")
	public ResponseEntity<Page<Schedule>> getAllSchedules(@RequestParam int pageNumber,@RequestParam int pageSize){
		return new ResponseEntity<>(scheduleService.getAllSchedules(pageNumber, pageSize), HttpStatus.OK);
	}
	
	/**
	 * Adds the schedule.
	 *
	 * @param scheduleDto the schedule dto
	 * @return the response entity
	 */
	@PostMapping(value = "/v1/schedule/add")
	public ResponseEntity<Schedule> addSchedule(@RequestBody ScheduleDto scheduleDto){
		return new ResponseEntity<>(scheduleService.addSchedule(scheduleDto), HttpStatus.OK);
	}
	
	/**
	 * Update schedule.
	 *
	 * @param scheduleDto the schedule dto
	 * @return the response entity
	 */
	@PutMapping(value = "/v1/schedule/update")
	public ResponseEntity<Schedule> updateSchedule(@RequestBody ScheduleDto scheduleDto){
		return new ResponseEntity<>(scheduleService.updateSchedule(scheduleDto), HttpStatus.OK);
	}
	
}

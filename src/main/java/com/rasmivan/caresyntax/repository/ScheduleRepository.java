package com.rasmivan.caresyntax.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rasmivan.caresyntax.domain.Schedule;
import com.rasmivan.caresyntax.dto.ScheduleDto;


@Transactional
@CacheConfig(cacheNames={"schedule_repo"})
public interface ScheduleRepository  extends JpaRepository<Schedule, Long>, JpaSpecificationExecutor<Schedule> {
	
	@CacheEvict(value = "schedule", allEntries = true)
	<S extends Schedule> S save(S entity);
	
	@Cacheable(value = "study",  key="{#schedule}")
	@Query("Select NEW com.rasmivan.caresyntax.dto.ScheduleDto("
			+ "sched.id, "
			+ "sched.study.id, "
			+ "sched.doctor.id,"
			+ "sched.room.id,"
			+ "sched.version,"
			+ "sched.study.plannedStartTime,"
			+ "sched.study.estimatedEndTime) "
			+ "from Schedule sched "
			+ "where sched.study.id = :studyId and "
			+ "sched.doctor.id = :doctorId")
	List<ScheduleDto> getscheduleByDoctorIdAndStudyId(@Param("doctorId")Long doctorId, @Param("studyId")Long studyId);
	
}

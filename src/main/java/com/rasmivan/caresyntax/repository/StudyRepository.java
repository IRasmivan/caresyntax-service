package com.rasmivan.caresyntax.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rasmivan.caresyntax.domain.Study;
import com.rasmivan.caresyntax.dto.StudyDto;

@Transactional
@CacheConfig(cacheNames={"study_repo"})
public interface StudyRepository  extends JpaRepository<Study, Long>, JpaSpecificationExecutor<Study> {
	
	
	@Cacheable(value = "study",  key="{#patientId}")
	@Query("Select NEW com.rasmivan.caresyntax.domain.Study("
			+ "std.id, "
			+ "std.description, "
			+ "std.status,"
			+ "std.plannedStartTime,"
			+ "std.estimatedEndTime,"
			+ "std.version) from Study std "
			+ "where std.patient.id = :patientId ")
	Study getStudyByPatientId(@Param("patientId")Long patientId);
	
	@Query("Select NEW com.rasmivan.caresyntax.dto.StudyDto("
			+ "std.id, "
			+ "std.patient.id, "
			+ "std.description, "
			+ "std.status,"
			+ "std.plannedStartTime,"
			+ "std.estimatedEndTime,"
			+ "std.version) from Study std "
			+ "where std.patient.name like :patientName ")
	StudyDto getStudyByPatientName(@Param("patientName")String patientName);
	
	@CacheEvict(value = "study", allEntries = true)
	<S extends Study> S save(S entity);
	
	@EntityGraph(attributePaths = {"patient"})
	Page<Study> findAll(Pageable pageable);

}

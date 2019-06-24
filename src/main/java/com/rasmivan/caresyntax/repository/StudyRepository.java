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

/**
 * The Interface StudyRepository.
 */
@Transactional
@CacheConfig(cacheNames={"study_repo"})
public interface StudyRepository  extends JpaRepository<Study, Long>, JpaSpecificationExecutor<Study> {
	
	
	/**
	 * Gets the study by patient id.
	 *
	 * @param patientId the patient id
	 * @return the study by patient id
	 */
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
	
	/**
	 * Gets the study by patient name.
	 *
	 * @param patientName the patient name
	 * @return the study by patient name
	 */
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
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#save(S)
	 */
	@CacheEvict(value = "study", allEntries = true)
	<S extends Study> S save(S entity);
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	@EntityGraph(attributePaths = {"patient"})
	Page<Study> findAll(Pageable pageable);

}

package com.rasmivan.caresyntax.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rasmivan.caresyntax.domain.Patient;


/**
 * The Interface PatientRepository.
 */
@Transactional
@CacheConfig(cacheNames={"patient_repo"})
public interface PatientRepository  extends JpaRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#save(S)
	 */
	@CacheEvict(value = "patient", allEntries = true)
	<S extends Patient> S save(S entity);
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	@CacheEvict(value = "patient", allEntries = true)
	void delete(Patient entity);

	/**
	 * Gets the by patient name.
	 *
	 * @param patientName the patient name
	 * @return the by patient name
	 */
	@Query("Select NEW com.rasmivan.caresyntax.domain.Patient("
			+ "pat.id, "
			+ "pat.name, "
			+ "pat.sex, "
			+ "pat.dateOfBirth,"
			+ "pat.version"
			+ ") from Patient pat "
			+ "where pat.name like :patientName")
	Patient getbyPatientName(@Param("patientName")String patientName);

}

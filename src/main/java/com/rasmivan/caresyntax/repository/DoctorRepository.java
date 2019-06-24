package com.rasmivan.caresyntax.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.rasmivan.caresyntax.domain.Doctor;


@Transactional
@CacheConfig(cacheNames={"doctor_repo"})
public interface DoctorRepository  extends JpaRepository<Doctor, Long>, JpaSpecificationExecutor<Doctor> {
	
	@CacheEvict(value = "doctor", allEntries = true)
	<S extends Doctor> S save(S entity);

}

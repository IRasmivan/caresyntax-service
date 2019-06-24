package com.rasmivan.caresyntax.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.rasmivan.caresyntax.domain.Room;

/**
 * The Interface RoomRepository.
 */
@Transactional
@CacheConfig(cacheNames={"room_repo"})
public interface RoomRepository  extends JpaRepository<Room, Long>, JpaSpecificationExecutor<Room> {
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#save(S)
	 */
	@CacheEvict(value = "room", allEntries = true)
	<S extends Room> S save(S entity);
	

}

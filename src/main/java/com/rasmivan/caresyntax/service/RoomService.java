package com.rasmivan.caresyntax.service;

import org.springframework.data.domain.Page;

import com.rasmivan.caresyntax.domain.Room;
import com.rasmivan.caresyntax.dto.RoomDto;

/**
 * The Interface RoomService.
 */
public interface RoomService {
	
	/**
	 * Gets the all rooms.
	 *
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the all rooms
	 */
	Page<Room> getAllRooms(int pageNumber, int pageSize);
	
	/**
	 * Adds the room.
	 *
	 * @param roomDto the room dto
	 * @return the room
	 */
	Room addRoom(RoomDto roomDto);
	
}

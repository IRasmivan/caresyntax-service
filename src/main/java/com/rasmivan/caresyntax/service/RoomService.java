package com.rasmivan.caresyntax.service;

import org.springframework.data.domain.Page;

import com.rasmivan.caresyntax.domain.Room;
import com.rasmivan.caresyntax.dto.RoomDto;

public interface RoomService {
	
	Page<Room> getAllRooms(int pageNumber, int pageSize);
	
	Room addRoom(RoomDto roomDto);
	
}

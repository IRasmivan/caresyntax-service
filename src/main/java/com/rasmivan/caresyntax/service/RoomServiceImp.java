package com.rasmivan.caresyntax.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rasmivan.caresyntax.constants.MessageConstantsUtils;
import com.rasmivan.caresyntax.domain.Room;
import com.rasmivan.caresyntax.dto.RoomDto;
import com.rasmivan.caresyntax.exception.InvalidRoomDetails;
import com.rasmivan.caresyntax.helper.CommonValidationUtils;
import com.rasmivan.caresyntax.repository.RoomRepository;

@Service
public class RoomServiceImp implements RoomService {
	
	@Autowired
	CommonValidationUtils commonValidationUtils;
	
	@Autowired
	RoomRepository roomRepository;

	@Override
	public Page<Room> getAllRooms(int pageNumber, int pageSize) {
		commonValidationUtils.validatePageSizeAndPageNumber(pageNumber, pageSize);
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return roomRepository.findAll(pageable);
	}

	@Override
	public Room addRoom(RoomDto roomDto) {
		Room room = new Room();
		
		if(roomDto.getName().trim().equals("")) {
			throw new InvalidRoomDetails(MessageConstantsUtils.INVALID_ROOM);
		}
		
		BeanUtils.copyProperties(roomDto, room);
		return roomRepository.save(room);
	}
	
}

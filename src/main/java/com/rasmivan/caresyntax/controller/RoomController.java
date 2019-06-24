package com.rasmivan.caresyntax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rasmivan.caresyntax.domain.Room;
import com.rasmivan.caresyntax.dto.RoomDto;
import com.rasmivan.caresyntax.service.RoomService;

@RestController
@CrossOrigin
@RequestMapping("/caresyntax/api")
public class RoomController {
	
	@Autowired
	RoomService roomService;

	@GetMapping(value = "/v1/rooms")
	public ResponseEntity<Page<Room>> getAllProducts(@RequestParam int pageNumber,@RequestParam int pageSize){
		return new ResponseEntity<>(roomService.getAllRooms(pageNumber, pageSize), HttpStatus.OK);
	}
	
	@PostMapping(value = "/v1/room/add")
	public ResponseEntity<Room> addProducts(@RequestBody RoomDto roomDto){
		return new ResponseEntity<>(roomService.addRoom(roomDto), HttpStatus.CREATED);
	}

}

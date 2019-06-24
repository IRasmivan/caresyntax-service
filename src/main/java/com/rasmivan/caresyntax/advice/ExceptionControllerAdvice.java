package com.rasmivan.caresyntax.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rasmivan.caresyntax.dto.ResponseDto;
import com.rasmivan.caresyntax.exception.InvalidPageNumberOrPageSize;
import com.rasmivan.caresyntax.exception.InvalidPatientDetails;
import com.rasmivan.caresyntax.exception.InvalidRoomDetails;
import com.rasmivan.caresyntax.exception.InvalidStudyDetails;
import com.rasmivan.caresyntax.exception.PatientStudyNotFound;


/**
 * The Class ExceptionControllerAdvice.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
	
	/** The logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
	
	@ExceptionHandler(value = InvalidPatientDetails.class)
	public ResponseEntity<ResponseDto> handleInvalidPatientDetailsException(InvalidPatientDetails e) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(e.getMessage());
		responseDto.setStatusCode(HttpStatus.PRECONDITION_FAILED.name());
		LOGGER.error(e.getMessage());
		return new ResponseEntity<>(responseDto, HttpStatus.PRECONDITION_FAILED);  // RETURN STATUS CODE AS 412
	}
	
	@ExceptionHandler(value = InvalidPageNumberOrPageSize.class)
	public ResponseEntity<ResponseDto> handleInvalidPageNumberOrPageSize(InvalidPageNumberOrPageSize e) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(e.getMessage());
		responseDto.setStatusCode(HttpStatus.PRECONDITION_FAILED.name());
		LOGGER.error(e.getMessage());
		return new ResponseEntity<>(responseDto, HttpStatus.PRECONDITION_FAILED);  // RETURN STATUS CODE AS 412
	}
	
	@ExceptionHandler(value = PatientStudyNotFound.class)
	public ResponseEntity<ResponseDto> handlePatientStudyNotFound(PatientStudyNotFound e) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(e.getMessage());
		responseDto.setStatusCode(HttpStatus.NOT_FOUND.name());
		LOGGER.error(e.getMessage());
		return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);  // RETURN STATUS CODE AS 404
	}
	
	@ExceptionHandler(value = InvalidStudyDetails.class)
	public ResponseEntity<ResponseDto> handleInvalidStudyDetails(InvalidStudyDetails e) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(e.getMessage());
		responseDto.setStatusCode(HttpStatus.PRECONDITION_FAILED.name());
		LOGGER.error(e.getMessage());
		return new ResponseEntity<>(responseDto, HttpStatus.PRECONDITION_FAILED);  // RETURN STATUS CODE AS 412
	}
	
	@ExceptionHandler(value = InvalidRoomDetails.class)
	public ResponseEntity<ResponseDto> handleInvalidRoomDetails(InvalidRoomDetails e) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(e.getMessage());
		responseDto.setStatusCode(HttpStatus.PRECONDITION_FAILED.name());
		LOGGER.error(e.getMessage());
		return new ResponseEntity<>(responseDto, HttpStatus.PRECONDITION_FAILED);  // RETURN STATUS CODE AS 412
	}

}

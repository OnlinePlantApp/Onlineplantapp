package com.cg.onlineplantnursery.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.plantnursery.seed.DTO.ExceptionDTOResponse;

@ControllerAdvice
public class CommonExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ExceptionDTOResponse> doSomeThings(EntityNotFoundException e)
	{
		ExceptionDTOResponse dto = new ExceptionDTOResponse();
		dto.setErrorMsg(e.getMessage());
		dto.setCommonName(null);
		return new ResponseEntity<ExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionDTOResponse> doSomeThingsForSeedName(SeedIdNotFoundException e)
	{
		ExceptionDTOResponse dto = new ExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setCommonName(null);
		return new ResponseEntity<ExceptionDTOResponse>(dto, HttpStatus.BAD_GATEWAY);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionDTOResponse> doSomeThingsForNullInput(NullPointerException e)
	{
		ExceptionDTOResponse dto = new ExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setCommonName(null);
		return new ResponseEntity<ExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);


}
}

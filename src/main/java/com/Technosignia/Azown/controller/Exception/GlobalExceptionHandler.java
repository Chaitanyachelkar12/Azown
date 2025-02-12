package com.Technosignia.Azown.controller.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Technosignia.Azown.Entity.Property;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundExceptionHandler(ResourceNotFoundException rx) {

		LocalDateTime time = null;
		Map<String, Object> response = new HashMap<>();
		response.put("message :", "This Property Is Not Found!");
		response.put("status :", "failure");
		response.put("timespan :", time.now());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<?> addressNotFoundExceptionHandler(AddressNotFoundException ax){
		
		LocalDateTime time = null;
		Map<String, Object> response = new HashMap<>();
		response.put("message :", "Address Is Null Please Fill The Address Data !");
		response.put("status :", "failure");
		response.put("timespan :", time.now());
		response.put("object :", ax.getEntity());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	

}

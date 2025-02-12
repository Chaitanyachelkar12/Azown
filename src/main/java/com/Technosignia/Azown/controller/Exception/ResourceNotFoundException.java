package com.Technosignia.Azown.controller.Exception;

import org.apache.logging.log4j.message.StringFormattedMessage;

import com.Technosignia.Azown.Entity.Property;

public class ResourceNotFoundException extends RuntimeException{
		
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String message,Throwable cause) {
		super(message,cause);
	}

	
	
}

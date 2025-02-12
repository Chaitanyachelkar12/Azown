package com.Technosignia.Azown.controller.Exception;

import com.Technosignia.Azown.Entity.Property;

public class AddressNotFoundException extends RuntimeException {

	private Property property;

	public AddressNotFoundException(String message) {
		super(message);
	}

	public AddressNotFoundException(String message, Property property) {
		super(message);
		this.property = property;

	}

	public Property getEntity() {
		return property;
	}
}

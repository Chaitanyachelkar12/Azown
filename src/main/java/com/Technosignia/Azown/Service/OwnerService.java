package com.Technosignia.Azown.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Technosignia.Azown.Entity.Address;
import com.Technosignia.Azown.Entity.Owner;
import com.Technosignia.Azown.Entity.Property;
import com.Technosignia.Azown.Repository.OwnerRepository;
import com.Technosignia.Azown.controller.OwnerController;
import com.Technosignia.Azown.controller.Exception.AddressNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class OwnerService {

	@Autowired
	OwnerRepository ownerrepository;

	@Autowired
	PropertyService propertyService;

	@Autowired
	AddressService addressService;

	@Transactional
	public Owner addOwnerData(Owner ownerProperty)  {
		List<Property> getOwnProperty = ownerProperty.getProperty();

		List<Property> setListProperty = new ArrayList();
		for (Property property : getOwnProperty) {
			Property reProperty = propertyService.addProperty(property);
			setListProperty.add(reProperty);
		}
		ownerProperty.setProperty(setListProperty);

		Address address = ownerProperty.getAddress();
		Address reAddress = addressService.createAddressDetails(address);
		ownerProperty.setAddress(reAddress);
		return ownerrepository.save(ownerProperty);
	}

	public ResponseEntity<?> getOwnerPropertiesByOwnerId(Integer id) {
		Optional<Owner> opOwner = ownerrepository.findById(id);
		if (opOwner.isPresent()) {
			Owner owner = opOwner.get();
			return new ResponseEntity<>(owner, HttpStatus.OK);
		} else {
			return new ResponseEntity("Not owner present", HttpStatus.NOT_FOUND);
		}
	}

}

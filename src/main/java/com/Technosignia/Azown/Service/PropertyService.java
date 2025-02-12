package com.Technosignia.Azown.Service;

import java.awt.event.FocusEvent.Cause;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.sql.ast.Clause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.Technosignia.Azown.Dto.PropertyDto;
import com.Technosignia.Azown.Entity.Address;
import com.Technosignia.Azown.Entity.Property;
import com.Technosignia.Azown.Repository.PropertyRepository;
import com.Technosignia.Azown.controller.Exception.AddressNotFoundException;
import com.Technosignia.Azown.controller.Exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PropertyService {


	@Autowired
	PropertyRepository propertyRepository;

	@Autowired
	AddressService addressService;

	//@Transactional(rollbackOn  = Exception.class)
	public Property addProperty(Property property) {
		Address address = property.getAddress();

		if (address != null) {
			Address reAddress = addressService.createAddressDetails(address);
			property.setAddress(reAddress);
		} else {
			
			throw new AddressNotFoundException("Address Not Be Null Please Fill The Addresss Details",property);
		}

		return propertyRepository.save(property);
	}

	public ResponseEntity<?> getProperty(Long id) {

		Optional<Property> opProp = propertyRepository.findById(id);
		if (opProp.isPresent()) {
			Property prop = opProp.get();
			return new ResponseEntity(prop, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Property Not Found With Id " + id, new Throwable("Database error"));

			// return new ResponseEntity("This Record is Not Present",HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<String> deletePropertyDetailsById(Long id) {

		if (propertyRepository.findById(id).isPresent()) {
			propertyRepository.deleteById(id);

			return new ResponseEntity("Record deleted SucessFully", HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Property Is Already Deleted This Id " + id);
		}

	}

	@Transactional
	public Property updateSomeProperty(Property property) {
		Long gid = property.getId();
		Property existing = propertyRepository.findById(gid).get();
		if (property.getName() != null) {
			existing.setName(property.getName());
		}

		if (property.getAddress() != null) {
			existing.setAddress(property.getAddress());
		}

		if (property.getConfigure() != null) {
			existing.setConfigure(property.getConfigure());
		}

		if (property.getStatus() != null) {
			existing.setStatus(property.getStatus());
		}

		return existing;
	}

	@Transactional
	public Property updateProperty(Property property, Long id) {
		Optional<Property> prop = propertyRepository.findById(id);
		Property opProp = null;
		if (prop.isPresent()) {
			opProp = prop.get();

			if (property.getAddress() != null) {
				opProp.setAddress(property.getAddress());
			} 	/*
				 * else { return PropertyResponseService.checkStatus(); }
				 */
			if (property.getDeposite() != null) {
				opProp.setDeposite(property.getDeposite());
			}
			if (property.getConfigure() != null) {
				opProp.setConfigure(property.getConfigure());
			}
			if (property.getId() != null) {
				opProp.setId(property.getId());
			}
			if (property.getName() != null) {
				opProp.setName(property.getName());
			}
			if (property.getStatus() != null) {
				opProp.setStatus(property.getStatus());
			}
			if (property.getRentalPrice() != null) {
				opProp.setRentalPrice(property.getRentalPrice());
			}
			if (property.getSellprice() != null) {
				opProp.setSellprice(property.getSellprice());
			}
			if (property.getType() != null) {
				opProp.setType(property.getType());
			}
			/*
			 * if(property.getOwner()!= null) { opProp.setOwner(property.getOwner()); }
			 */
			opProp = propertyRepository.save(opProp);
		}
			return opProp;
	}

	@Transactional
	public ResponseEntity<?> findProperties(String configuration, String type) {
		List<Property> opProp = propertyRepository.findByConfigureAndType(configuration, type);
		

		if (!opProp.isEmpty()) {
			return new ResponseEntity(opProp, HttpStatus.OK);
		} else {
			return new ResponseEntity("Not present this configure and type", HttpStatus.NOT_FOUND);
		}

	}

	@Transactional
	public ResponseEntity<?> searchPropertiesByRent(Double rentPrice) {
		List<Property> opProp = propertyRepository.findPropertiesByRentalPrice(rentPrice);
		if (!opProp.isEmpty()) {

			return new ResponseEntity(opProp, HttpStatus.OK);
		}

		return new ResponseEntity("Property Is Not Present", HttpStatus.NOT_FOUND);

	}
	
	public ResponseEntity<?> searchPropertiesByLargestRent(Double rentPrice) {
		List<Property> opProp = propertyRepository.findPropertiesByLargestRentalPrice(rentPrice);
		if (!opProp.isEmpty()) {

			return new ResponseEntity(opProp, HttpStatus.OK);
		}

		return new ResponseEntity("Property Is Not Present", HttpStatus.NOT_FOUND);

	}

	public List<PropertyDto> findAllPropertySomeProperty() {
		 List<Property> prop =propertyRepository.findAll();
		 
		return prop.stream().filter(p -> p.getRentalPrice() > 200000).map(p -> new PropertyDto(p.getId(), p.getName(), p.getConfigure(), p.getRentalPrice(), p.getSellprice())).collect(Collectors.toList());
	}


}

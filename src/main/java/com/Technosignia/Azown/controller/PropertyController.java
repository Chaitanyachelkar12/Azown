package com.Technosignia.Azown.controller;

import org.springframework.web.bind.annotation.RestController;

import com.Technosignia.Azown.Dto.PropertyDto;
import com.Technosignia.Azown.Entity.Property;

import com.Technosignia.Azown.Service.PropertyService;
import com.Technosignia.Azown.controller.Exception.AddressNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	PropertyService propertyService;

	@PostMapping("/postproperty")
	public Property createPropertyDetails(@RequestBody Property property) {

		return propertyService.addProperty(property);

	}

	@GetMapping("/getProperty")
	public ResponseEntity<?> getPropertyDetails(@RequestParam Long id) {

		return propertyService.getProperty(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePropertyDetails(@PathVariable Long id) {
		return propertyService.deletePropertyDetailsById(id);
	}

	@PatchMapping("/patchproperty")
	public Property updateSomeProperty(@RequestBody Property property) {
		return propertyService.updateSomeProperty(property);
	}

	@PutMapping("/putproperty") // request parameter
	public Property updateProperty(@RequestBody Property property, @RequestParam Long id) {

		return propertyService.updateProperty(property, id);
	}

	/*
	 * @PutMapping("/putproperty") public ResponseEntity<Object>
	 * updateProperty(@RequestBody Property property,@RequestParam Long id) {
	 * 
	 * Object result=propertyService.updateProperty(property,id);
	 * 
	 * if(result instanceof HttpStatus) { return new ResponseEntity<>(result,
	 * (HttpStatus) result); }else { return new ResponseEntity<>(result,
	 * HttpStatus.OK); } }
	 */

	/*
	 * @GetMapping("/getproperty/configure/location") public ResponseEntity<?>
	 * searchProperties(@RequestParam String configuration,@RequestParam String
	 * name){ List<Property> properties =
	 * propertyService.searchByConfigurationAndLocation(configuration,name); return
	 * new ResponseEntity(properties,HttpStatus.OK); }
	 */

	/*
	 * @GetMapping("/getproperty/configure/type") public ResponseEntity<?>
	 * searchProperties(@RequestParam String configuration,String type){ return
	 * propertyService.findProperties(configuration,type); }
	 */

	@GetMapping("/getproperty/rentalprice")
	public ResponseEntity<?> searchPropertiesByRentalPrice(@RequestParam Double rentalPrice) {

		return propertyService.searchPropertiesByRent(rentalPrice);
	}
	
	@GetMapping("/getproperty/rentalprice/large")
	public ResponseEntity<?> searchPropertiesByLargestRentalPrice(@RequestParam Double rentalPrice) {

		return propertyService.searchPropertiesByLargestRent(rentalPrice);
	}
	
	
	@GetMapping("/someproperty")
	public List<PropertyDto> getAllPropertySomeDetails() {
		return propertyService.findAllPropertySomeProperty();
	}
	
	
}


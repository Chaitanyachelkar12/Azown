package com.Technosignia.Azown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Technosignia.Azown.Entity.Owner;
import com.Technosignia.Azown.Service.OwnerService;
import com.Technosignia.Azown.controller.Exception.AddressNotFoundException;

@RestController
public class OwnerController {
	
	@Autowired
	OwnerService ownerservice;
	
	@PostMapping("/Owner")
	public Owner addOwnerService(@RequestBody Owner owner)  {
		
		return ownerservice.addOwnerData(owner);
	}
	
	@GetMapping("/Owner")
	 public ResponseEntity<?> findOwnerPropertiesByOwnerId(@RequestParam Integer id){
		return	ownerservice.getOwnerPropertiesByOwnerId(id);
	}
	
	
	
	
}

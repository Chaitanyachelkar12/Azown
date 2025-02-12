package com.Technosignia.Azown.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Technosignia.Azown.Entity.Address;
import com.Technosignia.Azown.Service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping("/addressAdd")
	public Address addAddressDetails(@RequestBody Address address) {
		return addressService.createAddressDetails(address);
	}
	
	@PutMapping("/addressEdit/{id}")
	public Address editAddressDetails(@PathVariable Long id, @RequestBody Address address) {
		return addressService.updateAddressDetails(address, id);
	}
	
	@GetMapping("/addressReturn")
	public ResponseEntity<?> getAddressDetails(@RequestParam Long id) {
		return addressService.readAddressDetails(id);
	}
	
	@GetMapping("/AddressAll")
	public List<Address> readAllAddressDetails(){
		return addressService.getAllAddress();
	}
	
	
}

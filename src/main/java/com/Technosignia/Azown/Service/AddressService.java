package com.Technosignia.Azown.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Technosignia.Azown.Entity.Address;
import com.Technosignia.Azown.Repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;

	public Address createAddressDetails(Address address) {
		return addressRepository.save(address);
	}
	
	public Address updateAddressDetails(Address address,Long id) {
		Optional<Address> checkAdd=addressRepository.findById(id);
		Address upAdd=null;
		if(checkAdd.isPresent()) {
			upAdd=checkAdd.get();
			
			if(address.getCity()!=null) {
				upAdd.setCity(address.getCity());
			}
			if(address.getCountry()!=null) {
				upAdd.setCountry(address.getCountry());
			}
			if(address.getPincode()!=null) {
				upAdd.setPincode(address.getPincode());
			}
			if(address.getState()!=null) {
				upAdd.setState(address.getState());
			}
			if(address.getStreet()!=null) {
				upAdd.setStreet(address.getStreet());
			}
			upAdd = addressRepository.save(upAdd);
		}
		
		return upAdd;
	}

	public ResponseEntity<?> readAddressDetails(Long id) {
		Optional<Address>checkAdd = addressRepository.findById(id);
		
		if(checkAdd.isPresent()) {
			return new ResponseEntity(checkAdd.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity("address is not present",HttpStatus.NOT_FOUND);
		}
	}

	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}
}


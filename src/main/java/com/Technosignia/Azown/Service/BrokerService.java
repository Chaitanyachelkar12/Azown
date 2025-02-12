package com.Technosignia.Azown.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Technosignia.Azown.Entity.Address;
import com.Technosignia.Azown.Entity.Broker;
import com.Technosignia.Azown.Repository.AddressRepository;
import com.Technosignia.Azown.Repository.BrokerRepository;

@Service
public class BrokerService {

	@Autowired
	BrokerRepository brokerRepository;
	
	@Autowired
	AddressService addressService;
	
	public Broker addBrokerDetails(Broker broker) {
		Address brokerAdd=broker.getAddress();
		broker.setAddress(addressService.createAddressDetails(brokerAdd));	
		return brokerRepository.save(broker);
	}

	public Broker editBrokerDetials(Long id, Broker broker) {
		Optional<Broker> checkBroker=brokerRepository.findById(id);
		
		Broker upBroker=null;
		if(checkBroker.isPresent()) {
			upBroker =checkBroker.get();
			if(broker.getContact()!=null) {
				upBroker.setContact(broker.getContact());
			}
			if(broker.getEmail()!=null) {
				upBroker.setEmail(broker.getEmail());
			}
			if(broker.getFname()!=null) {
				upBroker.setFname(broker.getFname());
			}
			if(broker.getLname()!=null) {
				upBroker.setLname(broker.getLname());
			}
			if(broker.getAddress()!=null) {
				upBroker.setAddress(addressService.updateAddressDetails(broker.getAddress(), broker.getAddress().getId()));
			}
			
			upBroker = brokerRepository.save(upBroker);
		}
			return upBroker;
	}

	public ResponseEntity<?> getBrokerDetails(Long id) {
		Optional<Broker> checkBroker= brokerRepository.findById(id);
		
		if(checkBroker.isPresent()) {
			return new ResponseEntity(checkBroker.get(),HttpStatus.OK);
		}
		return new ResponseEntity("Broker Details Of This Id Are Not Present", HttpStatus.NOT_IMPLEMENTED);
		
	}

	public List<Broker> getAllBrokerDetails() {
		return brokerRepository.findAll();
	}
	
}

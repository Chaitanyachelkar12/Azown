package com.Technosignia.Azown.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Technosignia.Azown.Entity.Broker;
import com.Technosignia.Azown.Service.BrokerService;

@RestController
@RequestMapping("/broker")
public class BrokerController {
	
	@Autowired
	BrokerService brokerService;
	
	@PostMapping("/BrokerAdd")
	public Broker postMethodName(@RequestBody Broker broker) {
		return brokerService.addBrokerDetails(broker);
	}
	
	@PutMapping("/BrokerEdit/{id}")
	public Broker updateBrokerDetails(@PathVariable Long id, @RequestBody Broker broker) {
		return brokerService.editBrokerDetials(id,broker);
	}
	
	@GetMapping("/BrokerRead")
	public ResponseEntity<?> readBrokerDetails(@RequestParam Long id) {
		return brokerService.getBrokerDetails(id);
	}
	
	@GetMapping("/BrokerAll")
	public List<Broker> readAllBrokerDetails() {
		return brokerService.getAllBrokerDetails();
	}
	
}

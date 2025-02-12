package com.Technosignia.Azown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Technosignia.Azown.Service.SearchService;

@RestController
public class SearchController {

	@Autowired
	SearchService propertyService;
	
	@GetMapping("/search")
	public ResponseEntity<?> searchProperties(@RequestParam String configuration,String type){
		return propertyService.searchByFindProperties(configuration,type);
	}
}

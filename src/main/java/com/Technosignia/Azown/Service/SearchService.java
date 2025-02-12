package com.Technosignia.Azown.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Technosignia.Azown.Entity.Property;
import com.Technosignia.Azown.Repository.PropertyRepository;

@Service
public class SearchService {

	@Autowired
	PropertyRepository propertyRepository;
	
	public ResponseEntity<?> searchByFindProperties(String configuration, String type) {
		List<Property> opProp= propertyRepository.findByConfigureAndType(configuration,type);
		
		if(!opProp.isEmpty()) 
		{
			return new ResponseEntity(opProp,HttpStatus.OK);
		}else {
			return new ResponseEntity("Not present this configure and type",HttpStatus.NOT_FOUND);
		}
		
	}
}

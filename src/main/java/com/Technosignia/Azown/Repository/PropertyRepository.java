package com.Technosignia.Azown.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Technosignia.Azown.Entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

	/*
	 * @Query (value =
	 * "select * from properties p where p.configuration =: configuration And p.name =:name"
	 * ) List<Property> findPropertiesByConfigurationAndLocation(
	 * 
	 * @Param ("configuration") String configuration,
	 * 
	 * @Param ("name") String name);
	 */ 

	@Query
	(nativeQuery = true, value="Select * from property where property.configure=:configure AND property.type=:type")
	List<Property> findByConfigureAndType(@Param ("configure") String configure, @Param("type") String Type);

	List<Property> findPropertiesByRentalPrice(@Param ("rentalPrice") Double rentalprice); 		//namedquery
	
	List<Property> findPropertiesByLargestRentalPrice(@Param ("rentalPrice") Double rentalprice); 	
}

package com.Technosignia.Azown.Entity;

import java.util.List;

import com.Technosignia.Azown.Dto.PropertyDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//@NamedQuery(name = "findPropertiesByRentalPrice", 
//query = "select p from Property p where p.rentalprice=:rentalprice")

@NamedQuery(
		  name = "Property.findPropertiesByRentalPrice",
		  query = "SELECT p FROM Property p WHERE p.rentalPrice =:rentalPrice"
		)

@NamedQuery(
		  name = "Property.findPropertiesByLargestRentalPrice",
		  query = "SELECT p FROM Property p WHERE p.rentalPrice >: rentalPrice"
		)

@Entity
public class Property {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min=8, max=50)
	private String name;

	@NotNull
	@OneToOne
	private Address address;

	// @ManyToOne
	// @JsonIgnore
	// Owner owner;

	private Double sellprice;
	private Double rentalPrice;
	private Double deposite;

	private String configure;
	private String type;
	private String status;

	/*
	 * public Owner getOwner() { return owner; }
	 * 
	 * public void setOwner(Owner owner) { this.owner = owner; }
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Double getSellprice() {
		return sellprice;
	}

	public void setSellprice(Double sellprice) {
		this.sellprice = sellprice;
	}

	public Double getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(Double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public Double getDeposite() {
		return deposite;
	}

	public void setDeposite(Double deposite) {
		this.deposite = deposite;
	}

	public String getConfigure() {
		return configure;
	}

	public void setConfigure(String configure) {
		this.configure = configure;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
/*	public PropertyDto getSomeProperties(Property property) {
		return new PropertyDto(property.getId(),property.getName(),property.getConfigure(),property.getRentalPrice(),property.getSellprice());
	}*/

}

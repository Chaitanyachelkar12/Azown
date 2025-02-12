package com.Technosignia.Azown.Dto;

public class PropertyDto {

	Long id;
	String name;
	String configure;
	Double rentalPrice;
	Double sellPrice;
	
	public PropertyDto(Long id, String name, String configure, Double rentalPrice, Double sellPrice) {
		super();
		this.id = id;
		this.name = name;
		this.configure = configure;
		this.rentalPrice = rentalPrice;
		this.sellPrice = sellPrice;
	}
	
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
	public String getConfigure() {
		return configure;
	}
	public void setConfigure(String configure) {
		this.configure = configure;
	}
	public Double getRentalPrice() {
		return rentalPrice;
	}
	public void setRentalPrice(Double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	public Double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	
}

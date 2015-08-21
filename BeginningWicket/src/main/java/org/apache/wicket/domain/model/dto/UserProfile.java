package org.apache.wicket.domain.model.dto;

import java.io.Serializable;

public class UserProfile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	private String city;
	private String country;
	private int pin;
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	@Override
	public String toString(){
		String result = " Mr " + getName();
		result+= "\n resides at " + getAddress();
		result+= "\n in the city " + getCity();
		result+= "\n having Pin Code " + getPin();
		result+= "\n in the country " + getCountry();
		return result;
		}
	
	
	
	
	
	
	
}

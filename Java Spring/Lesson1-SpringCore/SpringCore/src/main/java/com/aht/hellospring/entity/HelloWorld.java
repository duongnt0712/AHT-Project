package com.aht.hellospring.entity;

import java.util.Map;

public class HelloWorld {

	Map  addressMap;
//	private String message;

//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public void getMessage() {
//		System.out.println("Your Message : " + message);
//	}

	// a setter method to set Map
	   public void setAddressMap(Map addressMap) {
	      this.addressMap = addressMap;
	   }
	   
	   // prints and returns all the elements of the Map.
	   public Map getAddressMap() {
	      System.out.println("Map Elements :"  + addressMap);
	      return addressMap;
	   }
}
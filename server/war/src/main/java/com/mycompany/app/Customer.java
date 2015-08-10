package com.mycompany.app;

public class Customer {

	private String id;
	private String name;
	private String country;

	public Customer() {

	}

	public Customer(String id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}

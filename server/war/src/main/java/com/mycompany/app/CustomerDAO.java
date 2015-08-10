package com.mycompany.app;

import java.util.HashMap;
import java.util.Map;

public enum CustomerDAO {
	INSTANCE;
	
	private Map<String, Customer> customers = new HashMap<String, Customer>();

	private CustomerDAO() {

		// pumping-in some default data
		Customer customer = new Customer("1", "Kirk Kalvar", "USA");
		customers.put("1", customer);
		customer = new Customer("2", "Kent Kalvar", "USA");
		customers.put("2", customer);
	}

	public Map<String, Customer> getCustomers() {
		
		return customers;
	}

}

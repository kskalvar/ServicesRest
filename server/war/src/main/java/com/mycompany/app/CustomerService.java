package com.mycompany.app;

import java.util.Random;

public class CustomerService {

	CustomerDAO customerDAO;
	
	Random randomGenerator = new Random();

	public CustomerService() {
		
		customerDAO = CustomerDAO.INSTANCE;
	}
	
	public String returnUniqueId() {
		
		int random = randomGenerator.nextInt(Integer.MAX_VALUE) + 1;
		return String.valueOf(random);
	}

	public void createCustomer(Customer customer) {

		customerDAO.getCustomers().put(customer.getId(), customer);
	}

	public Customer getCustomer(String id) {
	
		return customerDAO.getCustomers().get(id);
	}
	
	public boolean checkCustomerExist(String id) {
		
		if (customerDAO.getCustomers().get(id) == null) {
			return false;
		} else {
			return true;
		}
	}

	public void deleteCustomer(String id) {
		
		customerDAO.getCustomers().remove(id);
	}
	
	public void updateCustomer(String id, Customer customer) {
	
		customerDAO.getCustomers().put(id, customer);
	}

}

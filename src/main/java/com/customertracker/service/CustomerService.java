package com.customertracker.service;

import java.util.List;

import com.customertracker.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void save(Customer theCustomer);

	public Customer getById(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomer(String theName);
	
}

package com.customertracker.dao;

import java.util.List;

import com.customertracker.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void save(Customer theCustomer);

	public Customer getById(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomer(String theName);
	
}

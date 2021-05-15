package com.customertracker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customertracker.dao.CustomerDAO;
import com.customertracker.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDao;

	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		customerDao.save(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getById(int theId) {
		return customerDao.getById(theId);
	}

}

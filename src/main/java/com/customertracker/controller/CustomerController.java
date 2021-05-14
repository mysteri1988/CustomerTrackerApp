package com.customertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customertracker.dao.CustomerDAO;
import com.customertracker.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private CustomerDAO customerDao;

	@Autowired
	public CustomerController(CustomerDAO customerDao) {
		this.customerDao = customerDao;
	}

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> customers = customerDao.getCustomers();

		theModel.addAttribute("customers", customers);

		return "list-customers";
	}
}

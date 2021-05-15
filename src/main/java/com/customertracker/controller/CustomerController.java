package com.customertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customertracker.entity.Customer;
import com.customertracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> customers = customerService.getCustomers();

		theModel.addAttribute("customers", customers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showCustomerForm(Model theModel) {

		var theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.save(theCustomer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int theId, Model theModel) {

		var customer = customerService.getById(theId);

		theModel.addAttribute("customer", customer);

		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {

		customerService.deleteCustomer(theId);

		return "redirect:/customer/list";
	}

	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theName, Model theModel) {

		var customers = customerService.searchCustomer(theName);

		theModel.addAttribute("customers", customers);

		return "list-customers";
	}

}

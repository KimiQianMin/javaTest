package com.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.dao.Customer;
import com.java.dao.CustomerRepoService;;

/**
 * Customer controller to handle request
 * 
 * @author Kimi Qian Min
 *
 */
@RestController
@RequestMapping("/1/customer")
@Validated
public class CustomerController {

	@Autowired
	private CustomerRepoService customerService; 

	/**
	 * Request path "/" handler
	 * 
	 * @param customerDto
	 */
	@PutMapping(value = "/")
	public Customer addOrUpdateCustomer(@Valid @RequestBody Customer customerDto) {
		return this.customerService.addOrUpdateCustomer(customerDto);
	}

	/**
	 * Request path "/{id}" handler
	 * 
	 * @param id
	 */
	@GetMapping(value = "/{id}")
	public Customer getCustomer(@PathVariable("id") @NonNull Long id) {
		return this.customerService.getCustomer(id);
	}

	/**
	 * Request path "" handler
	 * 
	 * @param lastName
	 */
	@GetMapping(value = "")
	public List<Customer> getCustomerByLastName(@RequestParam("lastName") @NonNull String lastName) {
		return this.customerService.getCustomerByLastName(lastName);
	}

	/**
	 * Request path {id} handler
	 * 
	 * @param id
	 */
	@DeleteMapping(value = "/{id}")
	public Boolean deleteCustomer(@PathVariable("id") @NonNull Long id) {
		return this.customerService.deleteCustomer(id);
	}

}

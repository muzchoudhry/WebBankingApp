package com.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.models.Account;
import com.bankapp.models.Customer;
import com.bankapp.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	//ID Counter
	//private long customerIdCount = 0000001;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	// Create/Save Customer
	public Customer saveCustomer(Customer customer) {
		//customer.setCustomerId(customerIdCount);
		customerRepository.save(customer);
		//customerIdCount++;
		return customer;
	}

	// Update Customer
	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	// Delete Customer
	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}

	// Retrieve Customer by ID
	public Optional<Customer> getCustomerById(long id) {
		return customerRepository.findById(id);
	}
	
	
	//Retrieves individual account (through repository)
//	public List<Account> getAccountByCustomer(long id) {
//		return customerRepository.findByCustomer(id);
//	}

	
	

}

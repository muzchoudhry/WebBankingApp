package com.bankapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.models.Account;
import com.bankapp.models.Customer;
import com.bankapp.service.AccountService;
import com.bankapp.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/")
	public List<Customer> customers(){
		//List<Customer> customers = customerService.getAllCustomers();
		return customerService.getAllCustomers();
	}

	@GetMapping("/{id}")
	private Optional<Customer> getCustomer(@PathVariable("id") long customerId) {
		return customerService.getCustomerById(customerId);
	}
		
	//Retrieve all accounts by customer - RestController method
	@GetMapping("/{id}/accounts")
	public List<Account> getAccountsByCustomer(@PathVariable Long id){
		Optional<Customer> customer = customerService.getCustomerById(id);
		
		if(customer.isPresent()) {
			Customer newCustomer = customer.get();
			return newCustomer.getAccounts();
		}
		return null;
	}

	
    @DeleteMapping("/{id}")
    private void deletePerson(@PathVariable("id") long customerId) {
        customerService.deleteCustomer(customerId);;
    }

    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
        //return customer.getCustomerId();
    }
    
    
  //Retrieve individual account of a customer
  	@GetMapping("/{id}/{accountid}")
  	public Optional<Account> getAccountByCustomer(@PathVariable("id") long customerId, @PathVariable("accountid") long accountNumber){
  		customerService.getCustomerById(customerId);
  		return accountService.getAccountById(accountNumber);
  	}

    
    
}
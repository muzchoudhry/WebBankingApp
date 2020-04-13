package com.bankapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.models.Account;
import com.bankapp.models.Transactions;
import com.bankapp.service.AccountService;
import com.bankapp.service.TransactionService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/accounts/{id}")
	public Optional<Account> getAccountById(@PathVariable("id") long id) {
		return accountService.getAccountById(id);
	}

	//Retrieve all transactions by account
	@GetMapping("/accounts/{id}/transactions")
	public List<Transactions> getTransactionsByAccount(@PathVariable Long id){
			Optional<Account> account = accountService.getAccountById(id);
			
			if(account.isPresent()) {
				return account.get().getTransactions();
			}
			return null;
		}
	
	//Retrieve individual transaction of an account
  	@GetMapping("/accounts/{id}/transactions/{transactionid}")
  	public Optional<Transactions> getAccountByCustomer(@PathVariable("id") long accountNumber, @PathVariable("transaction") long transactionNumber){
  		accountService.getAccountById(accountNumber);
  		return transactionService.getTransactionById(transactionNumber);
  	}
	
}

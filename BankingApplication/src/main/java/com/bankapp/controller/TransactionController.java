package com.bankapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.models.Transactions;
import com.bankapp.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transactions")
	public List<Transactions> getAllTransactions(){
		return transactionService.getAllTransactions();
	}
	
	@GetMapping("/transactions/{id}")
	public Optional<Transactions> getTransactionById(@PathVariable("id") long id) {
		return transactionService.getTransactionById(id);
	}
	
}

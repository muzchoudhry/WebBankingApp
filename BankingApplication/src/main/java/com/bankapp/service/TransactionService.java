package com.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.models.Transactions;
import com.bankapp.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Transactions> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public Optional<Transactions> getTransactionById(long id) {
		return transactionRepository.findById(id);
	}

	
}

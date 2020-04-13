package com.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.models.Account;
import com.bankapp.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	public Optional<Account> getAccountById(long id) {
		return accountRepository.findById(id);
	}



}

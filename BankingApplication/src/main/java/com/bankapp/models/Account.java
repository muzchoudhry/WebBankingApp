package com.bankapp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@Column(name = "accountNumber")
	private long accountNumber;
	private double balance;
	//private double openingBalance;
	//private String accountType;
	//private long customerId;
	//private String DateOpened;
	//private double Interest;
	
	@ManyToOne
	@JoinColumn(name = "cid")
	private Customer customer;
	
	@OneToMany(mappedBy = "account")//(mappedBy = "transaction", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Transactions> transactions;
	
	
}

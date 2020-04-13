package com.bankapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "transactionNumber")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTIONS")
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transactionNumber")
	private long transactionNumber;
	private double Amount;
	//private String transactionDate;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	
	
}

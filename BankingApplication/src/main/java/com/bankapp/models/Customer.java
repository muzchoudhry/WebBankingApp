package com.bankapp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "customerId")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerId")
	private long customerId;
	private String firstName;
//	private String lastName;
//	private String address;
//	private String city;
//	private String province;
//	private String phone;
//	private String sin;
//	private String accountCreationDate;

	@OneToMany(mappedBy = "customer") // (mappedBy = "account", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Account> accounts;

}






//insert into Customer(customer_id, first_name) values(1, 'Adam Smith');
//insert into Location(customer_id, first_name) values(2, 'Caroline Smith');
//insert into Location(customer_id, first_name) values(3, 'Junior Junior');
//
//insert into Account(account_number, balance, cid) values(10001, 1200, 1);
//insert into Account(account_number, balance, cid) values(10002, 1300, 1);
//insert into Account(account_number, balance, cid) values(10011, 2000, 2);
//insert into Account(account_number, balance, cid) values(10222, 1200, 3);
//
//insert into Transactions(transaction_number, amount, account_id) values(111222, 35, 10001);
//insert into Transactions(transaction_number, amount, account_id) values(123456, 50, 10011);
//insert into Transactions(transaction_number, amount, account_id) values(456789, 10, 10222);
//insert into Transactions(transaction_number, amount, account_id) values(789123, 55, 10002);
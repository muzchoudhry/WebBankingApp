


insert into Customer(customer_id, first_name) values(1, 'Adam Smith');
insert into Customer(customer_id, first_name) values(2, 'Caroline Smith');
insert into Customer(customer_id, first_name) values(3, 'Junior Junior');

insert into Account(account_number, balance, cid) values(10001, 1200, 1);
insert into Account(account_number, balance, cid) values(10002, 1300, 1);
insert into Account(account_number, balance, cid) values(10011, 2000, 2);
insert into Account(account_number, balance, cid) values(10222, 1200, 3);

insert into Transactions(transaction_number, amount, account_id) values(111222, 35, 10001);
insert into Transactions(transaction_number, amount, account_id) values(123456, 50, 10011);
insert into Transactions(transaction_number, amount, account_id) values(456789, 10, 10222);
insert into Transactions(transaction_number, amount, account_id) values(789123, 55, 10002);
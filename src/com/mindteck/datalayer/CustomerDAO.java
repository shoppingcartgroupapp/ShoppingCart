package com.mindteck.datalayer;

import java.util.List;
import com.mindteck.entities.Customer;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface CustomerDAO {

	public int createCustomer(Customer c);
	public Customer readCustomer(int id);
	public List<Customer> readAllCustomers();
	public int updateCustomer(Customer c);
	public int deleteCustomer(int id) throws MySQLIntegrityConstraintViolationException;
	
}

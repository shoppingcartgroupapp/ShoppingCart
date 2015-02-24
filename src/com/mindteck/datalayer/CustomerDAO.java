package com.mindteck.datalayer;

import java.util.List;

import com.mindteck.businesslayer.DataDeletionException;
import com.mindteck.entities.Customer;

public interface CustomerDAO {

	public int createCustomer(Customer c);
	public Customer readCustomer(int id);
	public List<Customer> readAllCustomers();
	public int updateCustomer(Customer c);
	public int deleteCustomer(int id) throws DataDeletionException;
	
}

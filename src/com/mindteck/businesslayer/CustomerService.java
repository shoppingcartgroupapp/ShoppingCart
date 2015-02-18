package com.mindteck.businesslayer;

import java.util.List;

import com.mindteck.datalayer.CustomerDAO;
import com.mindteck.datalayer.DAOFactory;
import com.mindteck.entities.Customer;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class CustomerService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_DAO_FACTORY);
	CustomerDAO customerDAO = factory.getCustomerDAO();

	public int createCustomer(Customer c) {
		return customerDAO.createCustomer(c);
	}
	
	public Customer readCustomer(int id) {
		return customerDAO.readCustomer(id);
	}
	
	public List<Customer> readAllCustomers() {
		return customerDAO.readAllCustomers();
	}
	
	public int updateCustomer(Customer c) {
		return customerDAO.updateCustomer(c);
	}

	public int deleteCustomer(int id) throws MySQLIntegrityConstraintViolationException {
		return customerDAO.deleteCustomer(id);
	}
}

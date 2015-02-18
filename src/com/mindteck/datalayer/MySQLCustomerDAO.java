package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.entities.Customer;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MySQLCustomerDAO implements CustomerDAO {

	private final String TABLE_NAME = "customer";
	
	@Override
	public int createCustomer(Customer customer) {
		StringBuilder query = new StringBuilder();
		
		query.append("INSERT INTO " + TABLE_NAME);
		query.append(" ('first_name', 'last_name', 'address', 'dob', 'phone', 'email', 'password')");
		query.append(" VALUES (");
		query.append("'" + customer.getFirstName() + "', ");
		query.append("'" + customer.getLastName() + "', ");
		query.append("'" + customer.getAddress() + "', ");
		query.append("'" + customer.getDob() + "', ");
		query.append("'" + customer.getPhone() + "', ");
		query.append("'" + customer.getEmail() + "', ");
		query.append("'" + customer.getPassword() + "');");
		
		int result = 0;
		Connection conn = MySQLConnectionManager.getConnection();
		
		try {
			result = MySQLConnectionManager.executeUpdate(conn, query.toString());
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return result;
	}

	@Override
	public Customer readCustomer(int customerId) {
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT * FROM " + TABLE_NAME);
		query.append(" WHERE customer_id = " + customerId + ";");
		
		Customer customer = null;
		Connection conn = MySQLConnectionManager.getConnection();
		ResultSet resultSet = MySQLConnectionManager.executeQuery(conn, query.toString());
		
		try {
			if (resultSet.next()) {
				customer = new Customer();
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setAddress(resultSet.getString("address"));
				customer.setDob(resultSet.getDate("dob"));
				customer.setPhone(resultSet.getInt("phone"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return customer;
		
	}

	@Override
	public List<Customer> readAllCustomers() {
		List<Customer> customerList = new ArrayList<Customer>();
		
		StringBuilder query = new StringBuilder("SELECT * FROM " + TABLE_NAME + ";");
		
		Customer customer = null;
		Connection conn = MySQLConnectionManager.getConnection();
		ResultSet resultSet = MySQLConnectionManager.executeQuery(conn, query.toString());
		
		try {
			while (resultSet.next()) {
				customer = new Customer();
				customer.setCustomerId(resultSet.getInt("customer_id"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setAddress(resultSet.getString("address"));
				customer.setDob(resultSet.getDate("dob"));
				customer.setPhone(resultSet.getInt("phone"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customerList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return customerList;
	}

	@Override
	public int updateCustomer(Customer customer) {
		StringBuilder query = new StringBuilder();
		
		query.append("UPDATE " + TABLE_NAME);
		query.append(" SET ");
		query.append("first_name = '" + customer.getFirstName() + "', ");
		query.append("last_name = '" + customer.getLastName() + "', ");
		query.append("address = '" + customer.getAddress() + "', ");
		query.append("dob = '" + customer.getDob() + "', ");
		query.append("phone = '" + customer.getPhone() + "', ");
		query.append("email = '" + customer.getEmail() + "', ");
		query.append("password = '" + customer.getPassword() + "'");
		query.append(" WHERE customer_id = '" + customer.getCustomerId() + "';");
		
		int result = 0;
		Connection conn = MySQLConnectionManager.getConnection();
		
		try {
			result = MySQLConnectionManager.executeUpdate(conn, query.toString());
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return result;
	}

	@Override
	public int deleteCustomer(int customerId) throws MySQLIntegrityConstraintViolationException {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder query = new StringBuilder();
		
		query.append("DELETE FROM " + TABLE_NAME);
		query.append(" WHERE customer_id = '" + customerId + "';");
		
		int result = MySQLConnectionManager.executeUpdate(conn, query.toString());
		MySQLConnectionManager.closeConnection(conn);
		return result;
	}

}

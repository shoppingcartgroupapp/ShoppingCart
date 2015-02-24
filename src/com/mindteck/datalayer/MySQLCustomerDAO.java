package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.businesslayer.DataDeletionException;
import com.mindteck.entities.Customer;

public class MySQLCustomerDAO implements CustomerDAO {

	private final String readCustomerQuery;
	private final String createCustomerQuery;
	private final String updateCustomerQuery;
	private final String deleteCustomerQuery;
	private final String readAllCustomersQuery;
	private final String TABLE_NAME = "customer";
	
	{	
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT * FROM " + TABLE_NAME);
		readAllCustomersQuery = query.toString();
		query.setLength(0);
		
		query.append("INSERT INTO " + TABLE_NAME);
		query.append(" (`first_name`, `last_name`, `address`, `dob`, `phone`, `email`, `password`)");
		query.append(" VALUES (?, ?, ?, ?, ?, ?, ?);");
		createCustomerQuery = query.toString();
		query.setLength(0);
		
		query.append("SELECT * FROM " + TABLE_NAME);
		query.append(" WHERE customer_id = ?;");
		readCustomerQuery = query.toString();
		query.setLength(0);
		
		query.append("UPDATE " + TABLE_NAME);
		query.append(" SET ");
		query.append("first_name = ?, ");
		query.append("last_name = ?, ");
		query.append("address = ?, ");
		query.append("dob = ?, ");
		query.append("phone = ?, ");
		query.append("email = ?, ");
		query.append("password = ?");
		query.append(" WHERE customer_id = ?;");
		updateCustomerQuery = query.toString();
		query.setLength(0);
		
		query.append("DELETE FROM " + TABLE_NAME);
		query.append(" WHERE customer_id = ?;");
		deleteCustomerQuery = query.toString();
		
		query = null;
	}

	@Override
	public int createCustomer(Customer customer) {
		int result = 0;
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, createCustomerQuery);
		
		try {
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getLastName());
			stmt.setString(3, customer.getAddress());
			stmt.setDate(4, new Date(customer.getDob().getTime()));
			stmt.setLong(5, customer.getPhone());
			stmt.setString(6, customer.getEmail());
			stmt.setString(7, customer.getPassword());
			result = MySQLConnectionManager.executeUpdate(conn, stmt);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MySQLConnectionManager.closeConnection(conn);
		}
	
		return result;
	}

	@Override
	public Customer readCustomer(int customerId) {
		Customer customer = null;
		ResultSet resultSet = null;
		Connection conn =  MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, readCustomerQuery);
		
		try {
			stmt.setInt(1, customerId);
			resultSet = MySQLConnectionManager.executeQuery(conn, stmt);
			
			if (resultSet.next()) {
				customer = new Customer();
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setAddress(resultSet.getString("address"));
				customer.setDob(resultSet.getDate("dob"));
				customer.setPhone(resultSet.getLong("phone"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MySQLConnectionManager.closeConnection(conn);
		}
		
		return customer;
	}

	@Override
	public List<Customer> readAllCustomers() {
		Customer customer = null;
		ResultSet resultSet = null;
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = MySQLConnectionManager.getConnection();
		
		try {
			resultSet = MySQLConnectionManager.executeQuery(conn, readAllCustomersQuery);
			while (resultSet.next()) {
				customer = new Customer();
				customer.setCustomerId(resultSet.getInt("customer_id"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setAddress(resultSet.getString("address"));
				customer.setDob(resultSet.getDate("dob"));
				customer.setPhone(resultSet.getLong("phone"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customerList.add(customer);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MySQLConnectionManager.closeConnection(conn);
		}

		return customerList;
	}

	@Override
	public int updateCustomer(Customer customer) {
		int result = 0;
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, updateCustomerQuery);
		
		try {
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getLastName());
			stmt.setString(3, customer.getAddress());
			stmt.setDate(4, new Date(customer.getDob().getTime()));
			stmt.setLong(5, customer.getPhone());
			stmt.setString(6, customer.getEmail());
			stmt.setString(7, customer.getPassword());
			stmt.setInt(8, customer.getCustomerId());
			result = MySQLConnectionManager.executeUpdate(conn, stmt);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MySQLConnectionManager.closeConnection(conn);
		}
	
		return result;
	}

	@Override
	public int deleteCustomer(int customerId) throws DataDeletionException {
		int result = 0;
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, deleteCustomerQuery);
		
		try {
			stmt.setInt(1, customerId);
			result = MySQLConnectionManager.executeUpdate(conn, stmt);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new DataDeletionException();
		}
		finally {
			MySQLConnectionManager.closeConnection(conn);
		}
		
		return result;
	}

}

package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.entities.Supplier;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MySQLSupplierDAO implements SupplierDAO {

	private final String TABLE_NAME = "supplier";
	
	@Override
	public int createSupplier(Supplier supplier) {
		StringBuilder query = new StringBuilder();
		
		query.append("INSERT INTO " + TABLE_NAME);
		query.append(" ('name', 'address', 'phone', 'email', 'password')");
		query.append(" VALUES (");
		query.append("'" + supplier.getName() + "', ");
		query.append("'" + supplier.getAddress() + "', ");
		query.append("'" + supplier.getPhone() + "', ");
		query.append("'" + supplier.getEmail() + "', ");
		query.append("'" + supplier.getPassword() + "');");
		
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
	public Supplier readSupplier(int supplierId) {
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT * FROM " + TABLE_NAME);
		query.append(" WHERE supplier_id = " + supplierId + ";");
		
		Supplier supplier = null;
		Connection conn = MySQLConnectionManager.getConnection();
		ResultSet resultSet = MySQLConnectionManager.executeQuery(conn, query.toString());
		
		try {
			if (resultSet.next()) {
				supplier = new Supplier();
				supplier.setSupplierId(resultSet.getInt("supplier_id"));
				supplier.setName(resultSet.getString("name"));
				supplier.setAddress(resultSet.getString("address"));
				supplier.setPhone(resultSet.getInt("phone"));
				supplier.setEmail(resultSet.getString("email"));
				supplier.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return supplier;
	}

	@Override
	public List<Supplier> readAllSuppliers() {
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT * FROM " + TABLE_NAME + ";");
		
		Supplier supplier = null;
		List<Supplier> supplierList = new ArrayList<Supplier>();
		Connection conn = MySQLConnectionManager.getConnection();
		ResultSet resultSet = MySQLConnectionManager.executeQuery(conn, query.toString());
		
		try {
			while (resultSet.next()) {
				supplier = new Supplier();
				supplier.setSupplierId(resultSet.getInt("supplier_id"));
				supplier.setName(resultSet.getString("name"));
				supplier.setAddress(resultSet.getString("address"));
				supplier.setPhone(resultSet.getInt("phone"));
				supplier.setEmail(resultSet.getString("email"));
				supplier.setPassword(resultSet.getString("password"));
				supplierList.add(supplier);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return supplierList;
	}

	@Override
	public int updateSupplier(Supplier supplier) {
		StringBuilder query = new StringBuilder();
		
		query.append("UPDATE " + TABLE_NAME);
		query.append(" SET ");
		query.append("name = '" + supplier.getName() + "', ");
		query.append("address = '" + supplier.getAddress() + "', ");
		query.append("phone = '" + supplier.getPhone() + "', ");
		query.append("email = '" + supplier.getEmail() + "', ");
		query.append("password = '" + supplier.getPassword() + "'");
		query.append(" WHERE supplier_id = '" + supplier.getSupplierId() + "';");
		
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
	public int deleteSupplier(int supplierId) throws MySQLIntegrityConstraintViolationException {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder query = new StringBuilder();
		
		query.append("DELETE FROM " + TABLE_NAME);
		query.append(" WHERE supplier_id = '" + supplierId + "';");
		
		int result = MySQLConnectionManager.executeUpdate(conn, query.toString());
		MySQLConnectionManager.closeConnection(conn);
		return result;
	}

}
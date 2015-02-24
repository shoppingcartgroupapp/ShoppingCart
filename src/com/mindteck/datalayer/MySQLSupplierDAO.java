package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.businesslayer.DataDeletionException;
import com.mindteck.entities.Supplier;

public class MySQLSupplierDAO implements SupplierDAO {

	private final String readSupplierQuery;
	private final String createSupplierQuery;
	private final String updateSupplierQuery;
	private final String deleteSupplierQuery;
	private final String readAllSuppliersQuery;
	private final String TABLE_NAME = "supplier";
	
	{
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT * FROM " + TABLE_NAME);
		readAllSuppliersQuery = query.toString();
		query.setLength(0);
		
		query.append("INSERT INTO " + TABLE_NAME);
		query.append(" (`name`, `address`, `phone`, `email`, `password`)");
		query.append(" VALUES (?, ?, ?, ?, ?);");
		createSupplierQuery = query.toString();
		query.setLength(0);
		
		query.append("SELECT * FROM " + TABLE_NAME);
		query.append(" WHERE customer_id = ?;");
		readSupplierQuery = query.toString();
		query.setLength(0);
		
		query.append("UPDATE " + TABLE_NAME);
		query.append(" SET ");
		query.append("name = ?, ");
		query.append("address = ?, ");
		query.append("phone = ?, ");
		query.append("email = ?, ");
		query.append("password = ?");
		query.append(" WHERE supplier_id = ?;");
		updateSupplierQuery = query.toString();
		query.setLength(0);
		
		query.append("DELETE FROM " + TABLE_NAME);
		query.append(" WHERE supplier_id = ?;");
		deleteSupplierQuery = query.toString();
		
		query = null;
	}
	
	@Override
	public int createSupplier(Supplier supplier) {
		int result = 0;
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, createSupplierQuery);
		
		try {
			stmt.setString(1, supplier.getName());
			stmt.setString(2, supplier.getAddress());
			stmt.setLong(3, supplier.getPhone());
			stmt.setString(4,supplier.getEmail());
			stmt.setString(5, supplier.getPassword());
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
	public Supplier readSupplier(int supplierId) {
		Supplier supplier = null;
		ResultSet resultSet = null;
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, readSupplierQuery);
		
		try {
			stmt.setInt(1, supplierId);
			resultSet = MySQLConnectionManager.executeQuery(conn, stmt);
			
			if (resultSet.next()) {
				supplier = new Supplier();
				supplier.setSupplierId(resultSet.getInt("supplier_id"));
				supplier.setName(resultSet.getString("name"));
				supplier.setAddress(resultSet.getString("address"));
				supplier.setPhone(resultSet.getLong("phone"));
				supplier.setEmail(resultSet.getString("email"));
				supplier.setPassword(resultSet.getString("password"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MySQLConnectionManager.closeConnection(conn);
		}
		
		return supplier;
	}

	@Override
	public List<Supplier> readAllSuppliers() {		
		Supplier supplier = null;
		List<Supplier> supplierList = new ArrayList<Supplier>();
		Connection conn = MySQLConnectionManager.getConnection();
		ResultSet resultSet = MySQLConnectionManager.executeQuery(conn, readAllSuppliersQuery);
		
		try {
			while (resultSet.next()) {
				supplier = new Supplier();
				supplier.setSupplierId(resultSet.getInt("supplier_id"));
				supplier.setName(resultSet.getString("name"));
				supplier.setAddress(resultSet.getString("address"));
				supplier.setPhone(resultSet.getLong("phone"));
				supplier.setEmail(resultSet.getString("email"));
				supplier.setPassword(resultSet.getString("password"));
				supplierList.add(supplier);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MySQLConnectionManager.closeConnection(conn);
		}

		return supplierList;
	}

	@Override
	public int updateSupplier(Supplier supplier) {
		int result = 0;
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, updateSupplierQuery);
		
		try {
			stmt.setString(1, supplier.getName());
			stmt.setString(2, supplier.getAddress());
			stmt.setLong(3, supplier.getPhone());
			stmt.setString(4, supplier.getEmail());
			stmt.setString(5, supplier.getPassword());
			stmt.setInt(6, supplier.getSupplierId());
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
	public int deleteSupplier(int supplierId) throws DataDeletionException {
		int result = 0;
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, deleteSupplierQuery);
		
		try {
			stmt.setInt(1, supplierId);
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

}
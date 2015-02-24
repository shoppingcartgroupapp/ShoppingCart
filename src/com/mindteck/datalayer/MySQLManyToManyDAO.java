package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.entities.Customer;
import com.mindteck.entities.Product;
import com.mindteck.entities.Supplier;

public class MySQLManyToManyDAO implements ManyToManyDAO {

	private final String SUPPLIER_TABLE_NAME = "supplier";
	private final String PRODUCT_TABLE_NAME = "product";
	private final String CUSTOMER_TABLE_NAME = "customer";
	private final String CUSTOMER_TO_PRODUCT_TABLE_NAME = "customer_product";
	private final String SUPPLIER_TO_PRODUCT_TABLE_NAME = "supplier_product";
	private final String readAllProductsForCustomerQuery;
	private final String readAllCustomersForProductQuery;
	private final String readAllProductsForSupplierQuery;
	private final String readAllSuppliersForProductQuery;
	
	{
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT ");
		query.append("product.product_id, "); 
		query.append("product.brand, ");
		query.append("product.name, ");
		query.append("product.price, ");
		query.append("product.quantity, ");
		query.append("product.description, ");
		query.append("product.image");
		query.append(" FROM ?");
		query.append(" JOIN ?");
		query.append(" ON ?.product_id = ?.product_id");
		query.append(" WHERE customer_id = ?;");
		readAllProductsForCustomerQuery = query.toString();
		query.setLength(0);
		
		query.append("SELECT ");
		query.append("customer.customer_id, ");
		query.append("customer.first_name, ");
		query.append("customer.last_name, ");
		query.append("customer.address, ");
		query.append("customer.dob, ");
		query.append("customer.phone, ");
		query.append("customer.email, ");
		query.append("customer.password");
		query.append(" FROM ?");
		query.append(" JOIN ?");
		query.append(" ON ?.customer_id = ?.customer_id");
		query.append(" WHERE product_id = ?;");
		readAllCustomersForProductQuery = query.toString();
		query.setLength(0);
		
		query.append("SELECT ");
		query.append("product.product_id, "); 
		query.append("product.brand, ");
		query.append("product.name, ");
		query.append("product.price, ");
		query.append("product.quantity, ");
		query.append("product.description, ");
		query.append("product.image");
		query.append(" FROM ?");
		query.append(" JOIN ?");
		query.append(" ON ?.product_id = ?.product_id");
		query.append(" WHERE supplier_id = ?;");
		readAllProductsForSupplierQuery = query.toString();
		query.setLength(0);
		
		query.append("SELECT ");
		query.append("supplier.supplier_id, ");
		query.append("supplier.name, ");
		query.append("supplier.address, ");
		query.append("supplier.phone, ");
		query.append("supplier.email, ");
		query.append("supplier.password");
		query.append(" FROM ?");
		query.append(" JOIN ?");
		query.append(" ON ?.supplier_id = ?.supplier_id");
		query.append(" WHERE product_id = ?;");
		readAllSuppliersForProductQuery = query.toString();
		
		query = null;
	}
	
	@Override
	public List<Product> readAllProductsForCustomer(int customerId) {
		Product product = null;
		ResultSet resultSet = null;
		List<Product> productList = new ArrayList<Product>();
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, readAllProductsForCustomerQuery);
		
		try {
			stmt.setString(1, PRODUCT_TABLE_NAME);
			stmt.setString(2, CUSTOMER_TO_PRODUCT_TABLE_NAME);
			stmt.setString(3, PRODUCT_TABLE_NAME);
			stmt.setString(4, CUSTOMER_TO_PRODUCT_TABLE_NAME);
			stmt.setInt(5, customerId);
			resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				product = new Product();
				product.setProductId(resultSet.getInt("product_id"));
				product.setBrand(resultSet.getString("brand"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getInt("quantity"));
				product.setDescription(resultSet.getString("description"));
				product.setImage(resultSet.getString("image"));
				productList.add(product);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MySQLConnectionManager.closeConnection(conn);
		}
		
		return productList;
	}

	@Override
	public List<Customer> readAllCustomersForProduct(int productId) {
		Customer customer = null;
		ResultSet resultSet = null;
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, readAllCustomersForProductQuery);
		
		try {
			stmt.setString(1, CUSTOMER_TABLE_NAME);
			stmt.setString(2, CUSTOMER_TO_PRODUCT_TABLE_NAME);
			stmt.setString(3, CUSTOMER_TABLE_NAME);
			stmt.setString(4, CUSTOMER_TO_PRODUCT_TABLE_NAME);
			stmt.setInt(5, productId);
			resultSet = stmt.executeQuery();
			
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
	public List<Product> readAllProductsForSupplier(int supplierId) {
		Product product = null;
		ResultSet resultSet = null;
		List<Product> productList = new ArrayList<Product>();
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, readAllProductsForSupplierQuery);
		
		try {
			stmt.setString(1, PRODUCT_TABLE_NAME);
			stmt.setString(2, SUPPLIER_TO_PRODUCT_TABLE_NAME);
			stmt.setString(3, PRODUCT_TABLE_NAME);
			stmt.setString(4, SUPPLIER_TO_PRODUCT_TABLE_NAME);
			stmt.setInt(5, supplierId);
			resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				product = new Product();
				product.setProductId(resultSet.getInt("product_id"));
				product.setBrand(resultSet.getString("brand"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getInt("quantity"));
				product.setDescription(resultSet.getString("description"));
				product.setImage(resultSet.getString("image"));
				productList.add(product);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MySQLConnectionManager.closeConnection(conn);
		}
		
		return productList;
	}

	@Override
	public List<Supplier> readAllSuppliersForProduct(int productId) {
		Supplier supplier = null;
		ResultSet resultSet = null;
		List<Supplier> supplierList = new ArrayList<Supplier>();
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, readAllSuppliersForProductQuery);
		
		try {
			stmt.setString(1, SUPPLIER_TABLE_NAME);
			stmt.setString(2, SUPPLIER_TO_PRODUCT_TABLE_NAME);
			stmt.setString(3, SUPPLIER_TABLE_NAME);
			stmt.setString(4, SUPPLIER_TO_PRODUCT_TABLE_NAME);
			stmt.setInt(5, productId);
			resultSet = stmt.executeQuery();
			
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
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MySQLConnectionManager.closeConnection(conn);
		}
		
		return supplierList;
	}

}

package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.entities.Customer;
import com.mindteck.entities.Product;
import com.mindteck.entities.Supplier;

public class MySQLManyToManyDAO implements ManyToManyDAO {

	private final String PRODUCT_TABLE_NAME = "product";
	private final String CUSTOMER_TABLE_NAME = "customer";
	private final String CUSTOMER_TO_PRODUCT_TABLE_NAME = "customer_product";
	private final String SUPPLIER_TO_PRODUCT_TABLE_NAME = "supplier_product";
	
	@Override
	public List<Product> getAllProductsForCustomer(int customerId) {
		List<Product> productList = new ArrayList<Product>();
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT ");
		query.append("product.product_id, "); 
		query.append("product.brand, ");
		query.append("product.name, ");
		query.append("product.price, ");
		query.append("product.quantity");
		query.append("product.description, ");
		query.append("product.image");
		query.append(" FROM " + PRODUCT_TABLE_NAME);
		query.append(" JOIN " + CUSTOMER_TO_PRODUCT_TABLE_NAME);
		query.append(" ON " + PRODUCT_TABLE_NAME + ".product_id = " + CUSTOMER_TO_PRODUCT_TABLE_NAME + ".product_id");
		query.append(" WHERE customer_id = " + customerId + ";");
		
		Product product = null;
		Connection conn = MySQLConnectionManager.getConnection();
		ResultSet resultSet = MySQLConnectionManager.executeQuery(conn, query.toString());
		
		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return productList;
	}

	@Override
	public List<Customer> getAllCustomersForProduct(int productId) {
		List<Customer> customerList = new ArrayList<Customer>();
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT ");
		query.append("customer.customer_id, ");
		query.append("customer.first_name, ");
		query.append("customer.last_name, ");
		query.append("customer.address, ");
		query.append("customer.dob, ");
		query.append("customer.phone, ");
		query.append("customer.email, ");
		query.append("customer.password");
		query.append(" FROM " + CUSTOMER_TABLE_NAME);
		query.append(" JOIN " + CUSTOMER_TO_PRODUCT_TABLE_NAME);
		query.append(" ON " + CUSTOMER_TABLE_NAME + ".customer_id = " + CUSTOMER_TO_PRODUCT_TABLE_NAME + ".customer_id");
		query.append(" WHERE product_id = " + productId + ";");
		
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
	public List<Product> getAllProductsForSupplier(int supplierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> getAllSuppliersForProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}

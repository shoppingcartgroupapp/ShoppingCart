package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.entities.Product;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MySQLProductDAO implements ProductDAO {

	private final String TABLE_NAME = "product";
	
	@Override
	public int createProduct(Product product) {
		StringBuilder query = new StringBuilder();
		
		query.append("INSERT INTO " + TABLE_NAME);
		query.append(" ('brand', 'name', 'price', 'quantity', 'description', 'image')");
		query.append(" VALUES (");
		query.append("'" + product.getBrand() + "', ");
		query.append("'" + product.getName() + "', ");
		query.append("'" + product.getPrice() + "', ");
		query.append("'" + product.getQuantity() + "', ");
		query.append("'" + product.getDescription() + "', ");
		query.append("'" + product.getImage() + "');");
		
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
	public Product readProduct(int productId) {
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT * FROM " + TABLE_NAME);
		query.append(" WHERE product_id = " + productId + ";");
		
		Product product = null;
		Connection conn = MySQLConnectionManager.getConnection();
		ResultSet resultSet = MySQLConnectionManager.executeQuery(conn, query.toString());
		
		try {
			if (resultSet.next()) {
				product = new Product();
				product.setBrand(resultSet.getString("brand"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getInt("quantity"));
				product.setDescription(resultSet.getString("description"));
				product.setImage(resultSet.getString("image"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return product;
	}

	@Override
	public List<Product> readAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		
		StringBuilder query = new StringBuilder("SELECT * FROM " + TABLE_NAME + ";");
		
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
	public int updateProduct(Product product) {
		StringBuilder query = new StringBuilder();
		
		query.append("UPDATE " + TABLE_NAME);
		query.append(" SET ");
		query.append("brand = '" + product.getBrand() + "', ");
		query.append("name = '" + product.getName() + "', ");
		query.append("price = '" + product.getPrice() + "', ");
		query.append("quantity = '" + product.getQuantity() + "', ");
		query.append("description = '" + product.getDescription() + "', ");
		query.append("image = '" + product.getImage() + "'");
		query.append(" WHERE product_id = '" + product.getProductId() + "';");
		
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
	public int deleteProduct(int productId) throws MySQLIntegrityConstraintViolationException {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder query = new StringBuilder();
		
		query.append("DELETE FROM " + TABLE_NAME);
		query.append(" WHERE product_id = '" + productId + "';");
		
		int result = MySQLConnectionManager.executeUpdate(conn, query.toString());
		MySQLConnectionManager.closeConnection(conn);
		return result;
	}

}

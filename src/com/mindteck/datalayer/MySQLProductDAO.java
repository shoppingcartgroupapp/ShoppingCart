package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.businesslayer.DataDeletionException;
import com.mindteck.entities.Product;

public class MySQLProductDAO implements ProductDAO {
	
	private final String readProductQuery;
	private final String createProductQuery;
	private final String updateProductQuery;
	private final String deleteProductQuery;
	private final String readAllProductsQuery;
	private final String TABLE_NAME = "product";
	
	{
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT * FROM " + TABLE_NAME);
		readAllProductsQuery = query.toString();
		query.setLength(0);
		
		query.append("INSERT INTO " + TABLE_NAME);
		query.append(" (`brand`, `name`, `category`, `subcategory`, `price`, `quantity`, `description`, `image`)");
		query.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
		createProductQuery = query.toString();
		query.setLength(0);
		
		query.append("SELECT * FROM " + TABLE_NAME);
		query.append(" WHERE product_id = ?;");
		readProductQuery = query.toString();
		query.setLength(0);
		
		query.append("UPDATE " + TABLE_NAME);
		query.append(" SET ");
		query.append("brand = ?, ");
		query.append("name = ?, ");
		query.append("category = ?, ");
		query.append("subcategory = ?, ");
		query.append("price = ?, ");
		query.append("quantity = ?, ");
		query.append("description = ?, ");
		query.append("image = ?");
		query.append(" WHERE product_id = ?;");
		updateProductQuery = query.toString();
		query.setLength(0);
		
		query.append("DELETE FROM " + TABLE_NAME);
		query.append(" WHERE product_id = ?;");
		deleteProductQuery = query.toString();
		
		query = null;
	}
	
	@Override
	public int createProduct(Product product) {
		int result = 0;
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, createProductQuery);

		try {
			stmt.setString(1, product.getBrand());
			stmt.setString(2, product.getName());
			stmt.setString(3, product.getCategory());
			stmt.setString(4, product.getSubcategory());
			stmt.setDouble(5, product.getPrice());
			stmt.setInt(6, product.getQuantity());
			stmt.setString(7, product.getDescription());
			stmt.setString(8, product.getImage());
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
	public Product readProduct(int productId) {
		Product product = null;
		ResultSet resultSet = null;
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, readProductQuery);
		
		try {
			stmt.setInt(1, productId);
			resultSet = MySQLConnectionManager.executeQuery(conn, stmt);
			
			if (resultSet.next()) {
				product = new Product();
				product.setBrand(resultSet.getString("brand"));
				product.setName(resultSet.getString("name"));
				product.setCategory(resultSet.getString("category"));
				product.setSubcategory(resultSet.getString("subcategory"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getInt("quantity"));
				product.setDescription(resultSet.getString("description"));
				product.setImage(resultSet.getString("image"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MySQLConnectionManager.closeConnection(conn);
		}
		
		return product;
	}

	@Override
	public List<Product> readAllProducts() {		
		Product product = null;
		List<Product> productList = new ArrayList<Product>();
		Connection conn = MySQLConnectionManager.getConnection();
		ResultSet resultSet = MySQLConnectionManager.executeQuery(conn, readAllProductsQuery);
		
		try {
			while (resultSet.next()) {
				product = new Product();
				product.setProductId(resultSet.getInt("product_id"));
				product.setBrand(resultSet.getString("brand"));
				product.setName(resultSet.getString("name"));
				product.setCategory(resultSet.getString("category"));
				product.setSubcategory(resultSet.getString("subcategory"));
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
	public int updateProduct(Product product) {
		int result = 0;
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, updateProductQuery);
		
		try {
			stmt.setString(1, product.getBrand());
			stmt.setString(2, product.getName());
			stmt.setString(3, product.getCategory());
			stmt.setString(4, product.getSubcategory());
			stmt.setDouble(5, product.getPrice());
			stmt.setInt(6, product.getQuantity());
			stmt.setString(7, product.getDescription());
			stmt.setString(8, product.getImage());
			stmt.setInt(9, product.getProductId());
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
	public int deleteProduct(int productId) throws DataDeletionException {
		int result = 0;
		Connection conn = MySQLConnectionManager.getConnection();
		PreparedStatement stmt = MySQLConnectionManager.getPreparedStatement(conn, deleteProductQuery);
		
		try {
			stmt.setInt(1, productId);
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

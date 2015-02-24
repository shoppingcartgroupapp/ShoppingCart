package com.mindteck.datalayer;

import java.util.List;

import com.mindteck.businesslayer.DataDeletionException;
import com.mindteck.entities.Product;

public interface ProductDAO {

	public int createProduct(Product c);
	public Product readProduct(int id);	
	public List<Product> readAllProducts();	
	public int updateProduct(Product c);
	public int deleteProduct(int id) throws DataDeletionException;
	
}

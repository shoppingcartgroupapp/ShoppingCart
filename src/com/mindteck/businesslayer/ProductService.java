package com.mindteck.businesslayer;

import java.util.List;

import com.mindteck.datalayer.DAOFactory;
import com.mindteck.datalayer.ProductDAO;
import com.mindteck.entities.Product;

public class ProductService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_DAO_FACTORY);
	ProductDAO productDAO = factory.getProductDAO();

	public int createProduct(Product c) {
		return productDAO.createProduct(c);
	}
	
	public Product readProduct(int id) {
		return productDAO.readProduct(id);
	}
	
	public List<Product> readAllProducts() {
		return productDAO.readAllProducts();
	}
	
	public int updateProduct(Product c) {
		return productDAO.updateProduct(c);
	}

	public int deleteProduct(int id) throws DataDeletionException {
		return productDAO.deleteProduct(id);
	}
}

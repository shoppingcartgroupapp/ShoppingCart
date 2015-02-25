package com.mindteck.businesslayer;

import java.util.List;

import com.mindteck.datalayer.DAOFactory;
import com.mindteck.datalayer.ManyToManyDAO;
import com.mindteck.entities.Customer;
import com.mindteck.entities.Product;
import com.mindteck.entities.Supplier;

public class ManyToManyService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_DAO_FACTORY);
	ManyToManyDAO manyToManyDAO = factory.getManyToManyDAO();
	
	public List<Product> readAllProductsForCustomer(int customerId) {
		return manyToManyDAO.readAllProductsForCustomer(customerId);
	}
	public List<Customer> readAllCustomersForProduct(int productId) {
		return manyToManyDAO.readAllCustomersForProduct(productId);
	}
	public List<Product> readAllProductsForSupplier(int supplierId) {
		return manyToManyDAO.readAllProductsForSupplier(supplierId);
	}
	public List<Supplier> readAllSuppliersForProduct(int productId) {
		return manyToManyDAO.readAllSuppliersForProduct(productId);
	}
	
}

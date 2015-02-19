package com.mindteck.datalayer;

import java.util.List;

import com.mindteck.entities.Customer;
import com.mindteck.entities.Product;
import com.mindteck.entities.Supplier;

public interface ManyToManyDAO {

	public List<Product> getAllProductsForCustomer(int customerId);
	public List<Customer> getAllCustomersForProduct(int productId);
	public List<Product> getAllProductsForSupplier(int supplierId);
	public List<Supplier> getAllSuppliersForProduct(int productId);
	
}

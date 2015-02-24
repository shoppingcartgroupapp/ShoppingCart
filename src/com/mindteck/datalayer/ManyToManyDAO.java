package com.mindteck.datalayer;

import java.util.List;

import com.mindteck.entities.Customer;
import com.mindteck.entities.Product;
import com.mindteck.entities.Supplier;

public interface ManyToManyDAO {

	public List<Product> readAllProductsForCustomer(int customerId);
	public List<Customer> readAllCustomersForProduct(int productId);
	public List<Product> readAllProductsForSupplier(int supplierId);
	public List<Supplier> readAllSuppliersForProduct(int productId);
	
}

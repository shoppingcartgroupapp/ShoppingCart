package com.mindteck.businesslayer;

import java.util.List;

import com.mindteck.entities.Product;
import com.mindteck.servlets.ManyToManyController;

public class ManyToManyService {

	ManyToManyController controller = new ManyToManyController();
	
	public List<Product> getAllProductsForCustomer(int customerId) {
		return controller.getAllProductsForCustomer(customerId);
	}
	
}

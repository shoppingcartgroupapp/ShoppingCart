package com.mindteck.businesslayer;

import java.util.List;

import com.mindteck.datalayer.DAOFactory;
import com.mindteck.datalayer.ManyToManyDAO;
import com.mindteck.entities.Product;

public class ManyToManyService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_DAO_FACTORY);
	ManyToManyDAO manyToManyDAO = factory.getManyToManyDAO();
	
	public List<Product> getAllProductsForCustomer(int customerId) {
		return manyToManyDAO.getAllProductsForCustomer(customerId);
	}
	
}

package com.mindteck.datalayer;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public CustomerDAO getCustomerDAO() {
		return new MySQLCustomerDAO();
	}
	
	@Override
	public ProductDAO getProductDAO() {
		return new MySQLProductDAO();
	}

	@Override
	public SupplierDAO getSupplierDAO() {
		return new MySQLSupplierDAO();
	}

}

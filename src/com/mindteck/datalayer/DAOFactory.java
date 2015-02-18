package com.mindteck.datalayer;

public abstract class DAOFactory {
	
	public static final int MYSQL_DAO_FACTORY = 1;
	public static final int ORACLE_DAO_FACTORY = 2;
	public static final int DB2_DAO_FACTORY = 3;
	
	public abstract CustomerDAO getCustomerDAO();
	public abstract ProductDAO getProductDAO();
	public abstract SupplierDAO getSupplierDAO();
	
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch(whichFactory) {
			case MYSQL_DAO_FACTORY: 
				return new MySQLDAOFactory();
			case ORACLE_DAO_FACTORY:
				return null;
			case DB2_DAO_FACTORY: 
				return null;
			default: 
				return null;
		}
	}
}
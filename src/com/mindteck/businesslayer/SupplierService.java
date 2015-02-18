package com.mindteck.businesslayer;

import java.util.List;

import com.mindteck.datalayer.DAOFactory;
import com.mindteck.datalayer.SupplierDAO;
import com.mindteck.entities.Supplier;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class SupplierService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_DAO_FACTORY);
	SupplierDAO supplierDAO = factory.getSupplierDAO();

	public int createSupplier(Supplier c) {
		return supplierDAO.createSupplier(c);
	}
	
	public Supplier readSupplier(int id) {
		return supplierDAO.readSupplier(id);
	}
	
	public List<Supplier> readAllSuppliers() {
		return supplierDAO.readAllSuppliers();
	}
	
	public int updateSupplier(Supplier c) {
		return supplierDAO.updateSupplier(c);
	}

	public int deleteSupplier(int id) throws MySQLIntegrityConstraintViolationException {
		return supplierDAO.deleteSupplier(id);
	}
}

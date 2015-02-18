package com.mindteck.datalayer;

import java.util.List;
import com.mindteck.entities.Supplier;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface SupplierDAO {

	public int createSupplier(Supplier c);
	public Supplier readSupplier(int id);
	public List<Supplier> readAllSuppliers();
	public int updateSupplier(Supplier c);
	public int deleteSupplier(int id) throws MySQLIntegrityConstraintViolationException;
	
}

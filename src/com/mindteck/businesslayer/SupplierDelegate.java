package com.mindteck.businesslayer;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.CreateException;

import com.mindteck.ejb.SupplierHome;
import com.mindteck.ejb.SupplierObject;
import com.mindteck.entities.Supplier;

public class SupplierDelegate {

	ServiceLocator serviceLocator = ServiceLocator.getInstance();
	SupplierObject supplierComponentInterface = null;
	
	public SupplierDelegate() {
		try {
			SupplierHome supplierHome = (SupplierHome) serviceLocator.getRemoteHome("Supplier", SupplierHome.class);
			supplierComponentInterface = supplierHome.create();
		} 
		catch (ServiceException e) { e.printStackTrace(); } 
		catch (RemoteException e) { e.printStackTrace(); } 
		catch (CreateException e) { e.printStackTrace(); }
	}
	
	public int createSupplier(Supplier s) throws RemoteException {
		return supplierComponentInterface.createSupplier(s);
	}
	
	public Supplier readSupplier(int id) throws RemoteException {
		return supplierComponentInterface.readSupplier(id);
	}
	
	public List<Supplier> readAllSuppliers() throws RemoteException {
		return supplierComponentInterface.readAllSuppliers();
	}
	
	public int updateSupplier(Supplier s) throws RemoteException {
		return supplierComponentInterface.updateSupplier(s);
	}

	public int deleteSupplier(int id) throws DataDeletionException, RemoteException {
		return supplierComponentInterface.deleteSupplier(id);
	}
}

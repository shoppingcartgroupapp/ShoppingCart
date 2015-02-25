package com.mindteck.businesslayer;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.CreateException;

import com.mindteck.ejb.ManyToManyHome;
import com.mindteck.ejb.ManyToManyObject;
import com.mindteck.entities.Customer;
import com.mindteck.entities.Product;
import com.mindteck.entities.Supplier;

public class ManyToManyDelegate {

	ServiceLocator serviceLocator = ServiceLocator.getInstance();
	ManyToManyObject manyToManyComponentInterface = null;
	
	public ManyToManyDelegate() {
		try {
			ManyToManyHome manyToManyHome = (ManyToManyHome) serviceLocator.getRemoteHome("ManyToMany", ManyToManyHome.class);
			manyToManyComponentInterface = manyToManyHome.create();
		} 
		catch (ServiceException e) { e.printStackTrace(); } 
		catch (RemoteException e) { e.printStackTrace(); } 
		catch (CreateException e) { e.printStackTrace(); }
	}
	
	public List<Product> readAllProductsForCustomer(int customerId) throws RemoteException {
		return  manyToManyComponentInterface.readAllProductsForCustomer(customerId);
	}
	public List<Customer> readAllCustomersForProduct(int productId) throws RemoteException {
		return  manyToManyComponentInterface.readAllCustomersForProduct(productId);
	}
	public List<Product> readAllProductsForSupplier(int supplierId) throws RemoteException {
		return  manyToManyComponentInterface.readAllProductsForSupplier(supplierId);
	}
	public List<Supplier> readAllSuppliersForProduct(int productId) throws RemoteException {
		return  manyToManyComponentInterface.readAllSuppliersForProduct(productId);
	}
	
}

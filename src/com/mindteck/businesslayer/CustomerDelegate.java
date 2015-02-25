package com.mindteck.businesslayer;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.CreateException;

import com.mindteck.ejb.CustomerHome;
import com.mindteck.ejb.CustomerObject;
import com.mindteck.entities.Customer;

public class CustomerDelegate {

	ServiceLocator serviceLocator = ServiceLocator.getInstance();
	CustomerObject customerComponentInterface = null;
	
	public CustomerDelegate() {
		try {
			CustomerHome customerHome = (CustomerHome) serviceLocator.getRemoteHome("Customer", CustomerHome.class);
			customerComponentInterface = customerHome.create();
		} 
		catch (ServiceException e) { e.printStackTrace(); } 
		catch (RemoteException e) { e.printStackTrace(); } 
		catch (CreateException e) { e.printStackTrace(); }
	}
	
	public int createCustomer(Customer c) throws RemoteException { 
		return customerComponentInterface.createCustomer(c);
	}
	
	public Customer readCustomer(int id) throws RemoteException { 
		return customerComponentInterface.readCustomer(id); 
	}
	
	public List<Customer> readAllCustomers() throws RemoteException { 
		return customerComponentInterface.readAllCustomers(); 
	}
	
	public int updateCustomer(Customer c) throws RemoteException { 
		return customerComponentInterface.updateCustomer(c); 
	}
	
	public int deleteCustomer(int id) throws DataDeletionException, RemoteException { 
		return customerComponentInterface.deleteCustomer(id); 
	}
	
}

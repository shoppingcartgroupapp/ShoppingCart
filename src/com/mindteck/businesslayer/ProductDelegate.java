package com.mindteck.businesslayer;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.CreateException;

import com.mindteck.ejb.ProductHome;
import com.mindteck.ejb.ProductObject;
import com.mindteck.entities.Product;

public class ProductDelegate {

	ServiceLocator serviceLocator = ServiceLocator.getInstance();
	ProductObject productComponentInterface = null;
	
	public ProductDelegate() {
		try {
			ProductHome productHome = (ProductHome) serviceLocator.getRemoteHome("Product", ProductHome.class);
			productComponentInterface = productHome.create();
		} 
		catch (ServiceException e) { e.printStackTrace(); } 
		catch (RemoteException e) { e.printStackTrace(); } 
		catch (CreateException e) { e.printStackTrace(); }
	}
	
	public int createProduct(Product p) throws RemoteException {
		return productComponentInterface.createProduct(p);
	}
	
	public Product readProduct(int id) throws RemoteException {
		return productComponentInterface.readProduct(id);
	}
	
	public List<Product> readAllProducts() throws RemoteException {
		return productComponentInterface.readAllProducts();
	}
	
	public int updateProduct(Product p) throws RemoteException {
		return productComponentInterface.updateProduct(p);
	}

	public int deleteProduct(int id) throws DataDeletionException, RemoteException {
		return productComponentInterface.deleteProduct(id);
	}
	
}

package com.mindteck.businesslayer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJBHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

public class ServiceLocator {

	private InitialContext context;
	private Map<String, Object> cache;
	private static ServiceLocator locatorInstance;
	
	static {
		try {
			locatorInstance = new ServiceLocator();
		}
		catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	
	private ServiceLocator() throws ServiceException {
		try {
			context = new InitialContext();
			cache = Collections.synchronizedMap(new HashMap<String, Object>());
		} catch (NamingException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}
	
	public static ServiceLocator getInstance() {
		return locatorInstance;
	}
	
	public EJBHome getRemoteHome(String jndiHomeName, Class<?> homeClassName) throws ServiceException {
		EJBHome remoteHome = null;

		if (cache.containsKey(jndiHomeName)) {
			remoteHome = (EJBHome) cache.get(jndiHomeName);
		} 
		else {
			try {
				Object obj = context.lookup(jndiHomeName);
				Object objHome = PortableRemoteObject.narrow(obj, homeClassName);
				remoteHome = (EJBHome) objHome;
				cache.put(jndiHomeName, remoteHome);
			} catch (NamingException e) {
				e.printStackTrace();
				throw new ServiceException();
			}
		}
		return remoteHome;
	}
	
	public DataSource getDataSource(String dataSourceName) throws ServiceException {
		DataSource dataSource = null;

		try {
			if (cache.containsKey(dataSourceName)) {
				dataSource = (DataSource) cache.get(dataSourceName);
			} else {
				dataSource = (DataSource) context.lookup(dataSourceName);
				cache.put(dataSourceName, dataSource);
			}

		} catch (NamingException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
		return dataSource;
	}
}

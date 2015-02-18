package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MySQLConnectionManager {

	private static DataSource dataSource;
	private static final Logger logger = LogManager.getLogger();
	
	static {
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			dataSource = getDataSource();
		}
		catch (ClassNotFoundException e) { e.printStackTrace(); }
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		
		logger.debug("Requesting DB Connection");
		try {
			conn = dataSource.getConnection();
		} 
		catch (SQLException e) {
			logger.error("Connection Request Failure\n");
			e.printStackTrace(); 
		}
		logger.debug("Connection Request Success\n");
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		logger.debug("Attempting to close DB Connection");
		try { 
			conn.close(); 
		}
		catch (SQLException e) {
			logger.error("Connection Close Failure\n");
			e.printStackTrace(); 
		}
		logger.debug("Connection Close Success\n");
	}
	
	//Insert, Delete, Update
	public static int executeUpdate(Connection conn, String query) throws MySQLIntegrityConstraintViolationException {
		Statement stmt = null;
		int success = 0;
		
		logger.warn("Executing: [" + query + "]\n");
		try {
			stmt = conn.prepareStatement(query);
			success = stmt.executeUpdate(query);
		}
		catch (MySQLIntegrityConstraintViolationException me) {
			throw me;
		}
		catch (SQLException e) {
			logger.error("Failed To Execute: [" + query + "]\n");
			e.printStackTrace();
		}
		
		return success;
	}
	
	//Select
	public static ResultSet executeQuery(Connection conn, String query) {
		Statement stmt = null;
		ResultSet rs = null;
		
		logger.warn("Executing: [" + query + "]\n");
		try { 
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery(query);
		} 
		catch (SQLException e) {
			logger.error("Failed To Execute: [" + query + "]\n");
			e.printStackTrace(); 
		}
		
		return rs;
	}

	private static DataSource getDataSource() {
        BasicDataSource dataSource = null;
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/mindteck");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
	}
}

package com.mindteck.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.businesslayer.CustomerService;
import com.mindteck.entities.Customer;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class CustomerController {

	private CustomerService customerService = new CustomerService();

	public void readAllCustomers(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("customerList", customerService.readAllCustomers());	
		RequestDispatcher view = request.getRequestDispatcher("jsp/customer.jsp");
		view.forward(request, response);

	}
	
	public void addCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("jsp/customerForm.jsp");
		view.forward(request, response);

	}
	
	public void createCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Customer customer = new Customer();
		customer.setFirstName(request.getParameter("first_name"));
		customer.setLastName(request.getParameter("last_name"));
		customer.setAddress(request.getParameter("address"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			customer.setDob(sdf.parse(request.getParameter("dob")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		customer.setPhone(Integer.parseInt(request.getParameter("phone")));
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		
		int result = customerService.createCustomer(customer);
		
		if (result == 0) {
			request.setAttribute("add", "failure");
		}
		else {
			request.setAttribute("add", "success");
		}
		
		readAllCustomers(request, response);

	}	

	public void updateCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Customer customer = new Customer();
		customer.setCustomerId(Integer.parseInt(request.getParameter("id")));
		customer.setFirstName(request.getParameter("first_name"));
		customer.setLastName(request.getParameter("last_name"));
		customer.setAddress(request.getParameter("address"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			customer.setDob(sdf.parse(request.getParameter("dob")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		customer.setPhone(Integer.parseInt(request.getParameter("phone")));
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		
		int result = customerService.updateCustomer(customer);
		
		if (result == 0) {
			request.setAttribute("update", "failure");
		}
		else {
			request.setAttribute("update", "success");
		}
		
		readAllCustomers(request, response);

	}

	public void deleteCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int customerId = Integer.parseInt(request.getParameter("id"));
		try {
			customerService.deleteCustomer(customerId);
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		request.setAttribute("delete", "success");
		readAllCustomers(request, response);

	}

}

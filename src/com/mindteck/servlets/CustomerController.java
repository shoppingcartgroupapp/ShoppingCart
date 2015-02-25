package com.mindteck.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindteck.businesslayer.CustomerDelegate;
import com.mindteck.businesslayer.DataDeletionException;
import com.mindteck.entities.Customer;

public class CustomerController {
	//Comment
	private CustomerDelegate customerDelegate = new CustomerDelegate();

	public void readAllCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> customerList = customerDelegate.readAllCustomers();
		PrintWriter out = response.getWriter();
		for (Customer c : customerList) {
			out.println(c + "<br /><br />");
		}
		
		// KEEP THIS - IT IS THE CORRECT VERSION. THE ABOVE IS FOR TESTING ONLY
		/*
		request.setAttribute("customerList", customerService.readAllCustomers());	
		RequestDispatcher view = request.getRequestDispatcher("jsp/customer.jsp");
		view.forward(request, response);
		*/
	}
	
	public void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		createCustomer(request, response);
		
		// KEEP THIS - IT IS THE CORRECT VERSION. THE ABOVE IS FOR TESTING ONLY
		/*
		RequestDispatcher view = request.getRequestDispatcher("jsp/customerForm.jsp");
		view.forward(request, response);
		*/
	}
	
	public void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setAddress(request.getParameter("address"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			customer.setDob(sdf.parse(request.getParameter("dob")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		customer.setPhone(Long.parseLong(request.getParameter("phone")));
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		
		int result = customerDelegate.createCustomer(customer);
		
		if (result == 0) {
			request.setAttribute("add", "failure");
		}
		else {
			request.setAttribute("add", "success");
		}
		
		readAllCustomers(request, response);
	}
	
	public void verifyCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer customer = new Customer();
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		
		request.setAttribute("accountType", request.getParameter("accountType"));
		
		List<Customer> customerList = customerDelegate.readAllCustomers();
		
		for (Customer c : customerList) {
			if (c.getEmail().equals(customer.getEmail())) {
				if (c.getPassword().equals(customer.getPassword())) {
					customer = c;
					request.setAttribute("login", "success");
					HttpSession session = request.getSession(true);
					session.setAttribute("user", customer.getFirstName());
					session.setMaxInactiveInterval(60*60);
				} else {
					request.setAttribute("login", "passwordFailure");
				}
			}
		}
		
		if (request.getAttribute("login") == null) {
			request.setAttribute("login", "emailFailure");
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
		view.forward(request, response);
				
	}
	
	public void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		updateCustomer(request, response);
		
		// KEEP THIS - IT IS THE CORRECT VERSION. THE ABOVE IS FOR TESTING ONLY
		/*
		int customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerService.readCustomer(customerId);
		request.setAttribute("first_name", customer.getFirstName());
		request.setAttribute("last_name", customer.getLastName());
		request.setAttribute("address", customer.getAddress());
		request.setAttribute("dob", customer.getDob());
		request.setAttribute("phone", customer.getPhone());
		request.setAttribute("email", customer.getEmail());
		request.setAttribute("password", customer.getPassword());

		RequestDispatcher view = request.getRequestDispatcher("jsp/customerForm.jsp");
		view.forward(request, response);
		*/
	}

	public void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		customer.setPhone(Long.parseLong(request.getParameter("phone")));
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		
		int result = customerDelegate.updateCustomer(customer);
		
		if (result == 0) {
			request.setAttribute("update", "failure");
		}
		else {
			request.setAttribute("update", "success");
		}
		
		readAllCustomers(request, response);
	}

	public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int customerId = Integer.parseInt(request.getParameter("id"));
		try {
			customerDelegate.deleteCustomer(customerId);
			request.setAttribute("delete", "success");
		} catch (DataDeletionException e) {
			request.setAttribute("delete", "failure");
		}
		finally {
			readAllCustomers(request, response);
		}
	}

}
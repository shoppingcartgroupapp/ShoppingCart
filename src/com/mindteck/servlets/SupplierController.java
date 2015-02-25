package com.mindteck.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindteck.businesslayer.DataDeletionException;
import com.mindteck.businesslayer.SupplierDelegate;
import com.mindteck.entities.Supplier;

public class SupplierController {

	private SupplierDelegate supplierDelegate = new SupplierDelegate();
	//private SupplierService supplierService = new SupplierService();

	public void readAllSuppliers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Supplier> supplierList = supplierDelegate.readAllSuppliers();
		PrintWriter out = response.getWriter();
		for (Supplier s : supplierList) {
			out.println(s + "<br /><br />");
		}
		
		// KEEP THIS - IT IS THE CORRECT VERSION. THE ABOVE IS FOR TESTING ONLY
		/*
		request.setAttribute("supplierList", supplierService.readAllSuppliers());	
		RequestDispatcher view = request.getRequestDispatcher("jsp/supplier.jsp");
		view.forward(request, response);
		*/
	}
	
	public void addSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		createSupplier(request, response);
		
		// KEEP THIS - IT IS THE CORRECT VERSION. THE ABOVE IS FOR TESTING ONLY
		/*
		RequestDispatcher view = request.getRequestDispatcher("jsp/supplierForm.jsp");
		view.forward(request, response);
		*/
	}
	
	public void createSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Supplier supplier = new Supplier();
		supplier.setName(request.getParameter("name"));
		supplier.setAddress(request.getParameter("address"));
		supplier.setPhone(Integer.parseInt(request.getParameter("phone")));
		supplier.setEmail(request.getParameter("email"));
		supplier.setPassword(request.getParameter("password"));
		
		int result = supplierDelegate.createSupplier(supplier);
		
		if (result == 0) {
			request.setAttribute("add", "failure");
		}
		else {
			request.setAttribute("add", "success");
		}
		
		readAllSuppliers(request, response);

	}
	
public void verifySupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Supplier supplier = new Supplier();
		supplier.setEmail(request.getParameter("email"));
		supplier.setPassword(request.getParameter("password"));
		
		request.setAttribute("accountType", request.getParameter("accountType"));
		
		List<Supplier> supplierList = supplierDelegate.readAllSuppliers();
		
		for (Supplier c : supplierList) {
			if (c.getEmail().equals(supplier.getEmail())) {
				if (c.getPassword().equals(supplier.getPassword())) {
					supplier = c;
					request.setAttribute("login", "success");
					HttpSession session = request.getSession(true);
					session.setAttribute("user", supplier.getName());
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
	
	public void editSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		updateSupplier(request, response);
		
		// KEEP THIS - IT IS THE CORRECT VERSION. THE ABOVE IS FOR TESTING ONLY
		/*
		int supplierId = Integer.parseInt(request.getParameter("id"));
		Supplier supplier = supplierService.readSupplier(supplierId);
		request.setAttribute("name", supplier.getName());
		request.setAttribute("address1", supplier.getAddress());
		request.setAttribute("phone", supplier.getPhone());
		request.setAttribute("email", supplier.getEmail());
		request.setAttribute("password", supplier.getPassword());

		RequestDispatcher view = request.getRequestDispatcher("jsp/supplierForm.jsp");
		view.forward(request, response);
		*/
	}

	public void updateSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Supplier supplier = new Supplier();
		supplier.setSupplierId(Integer.parseInt(request.getParameter("id")));
		supplier.setName(request.getParameter("name"));
		supplier.setAddress(request.getParameter("address"));
		supplier.setPhone(Integer.parseInt(request.getParameter("phone")));
		supplier.setEmail(request.getParameter("email"));
		supplier.setPassword(request.getParameter("password"));
		
		int result = supplierDelegate.updateSupplier(supplier);
		
		if (result == 0) {
			request.setAttribute("update", "failure");
		}
		else {
			request.setAttribute("update", "success");
		}
		
		readAllSuppliers(request, response);

	}

	public void deleteSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int supplierId = Integer.parseInt(request.getParameter("id"));
		
		try {
			supplierDelegate.deleteSupplier(supplierId);
			request.setAttribute("delete", "success");
		} catch (DataDeletionException e) {
			request.setAttribute("delete", "failure");
		}
		finally {
			readAllSuppliers(request, response);
		}

	}

}

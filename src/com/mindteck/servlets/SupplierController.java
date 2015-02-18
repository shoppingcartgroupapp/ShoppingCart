package com.mindteck.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.businesslayer.SupplierService;
import com.mindteck.entities.Supplier;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class SupplierController {

	private SupplierService supplierService = new SupplierService();

	public void readAllSuppliers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("supplierList", supplierService.readAllSuppliers());	
		RequestDispatcher view = request.getRequestDispatcher("jsp/supplier.jsp");
		view.forward(request, response);

	}
	
	public void addSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("jsp/supplierForm.jsp");
		view.forward(request, response);

	}
	
	public void createSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Supplier supplier = new Supplier();
		supplier.setName(request.getParameter("name"));
		supplier.setAddress(request.getParameter("address"));
		supplier.setPhone(Integer.parseInt(request.getParameter("phone")));
		supplier.setEmail(request.getParameter("email"));
		supplier.setPassword(request.getParameter("password"));
		
		int result = supplierService.createSupplier(supplier);
		
		if (result == 0) {
			request.setAttribute("add", "failure");
		}
		else {
			request.setAttribute("add", "success");
		}
		
		readAllSuppliers(request, response);

	}
	
	public void editSupplier(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int supplierId = Integer.parseInt(request.getParameter("id"));
		Supplier supplier = supplierService.readSupplier(supplierId);
		request.setAttribute("name", supplier.getName());
		request.setAttribute("address1", supplier.getAddress());
		request.setAttribute("phone", supplier.getPhone());
		request.setAttribute("email", supplier.getEmail());
		request.setAttribute("password", supplier.getPassword());

		RequestDispatcher view = request.getRequestDispatcher("jsp/supplierForm.jsp");
		view.forward(request, response);
		
	}

	public void updateSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Supplier supplier = new Supplier();
		supplier.setSupplierId(Integer.parseInt(request.getParameter("id")));
		supplier.setName(request.getParameter("name"));
		supplier.setAddress(request.getParameter("address"));
		supplier.setPhone(Integer.parseInt(request.getParameter("phone")));
		supplier.setEmail(request.getParameter("email"));
		supplier.setPassword(request.getParameter("password"));
		
		int result = supplierService.updateSupplier(supplier);
		
		if (result == 0) {
			request.setAttribute("update", "failure");
		}
		else {
			request.setAttribute("update", "success");
		}
		
		readAllSuppliers(request, response);

	}

	public void deleteSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MySQLIntegrityConstraintViolationException {
		
		int supplierId = Integer.parseInt(request.getParameter("id"));
		supplierService.deleteSupplier(supplierId);
		request.setAttribute("delete", "success");
		readAllSuppliers(request, response);

	}

}

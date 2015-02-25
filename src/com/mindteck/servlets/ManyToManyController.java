package com.mindteck.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.businesslayer.ManyToManyDelegate;

public class ManyToManyController {
	
	private  ManyToManyDelegate manyToManyDelegate = new ManyToManyDelegate();
	
	public void getAllProductsForCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customer_id"));
		request.setAttribute("productList", manyToManyDelegate.readAllProductsForCustomer(customerId));	
		RequestDispatcher view = request.getRequestDispatcher("");
		view.forward(request, response);
	}

}

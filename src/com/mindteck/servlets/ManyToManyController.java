package com.mindteck.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.businesslayer.ManyToManyService;

public class ManyToManyController {
	
	private ManyToManyService manyToManyService = new ManyToManyService();
	
	public void getAllProductsForCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customer_id"));
		request.setAttribute("productList", manyToManyService.readAllProductsForCustomer(customerId));	
		RequestDispatcher view = request.getRequestDispatcher("");
		view.forward(request, response);
	}

}

package com.mindteck.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.businesslayer.ProductService;
import com.mindteck.entities.Product;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class ProductController {

	private ProductService productService = new ProductService();

	public void readAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("productList", productService.readAllProducts());	
		RequestDispatcher view = request.getRequestDispatcher("jsp/product.jsp");
		view.forward(request, response);

	}
	
	public void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("jsp/productForm.jsp");
		view.forward(request, response);

	}
	
	public void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		product.setBrand(request.getParameter("brand"));
		product.setName(request.getParameter("name"));
		product.setPrice(Double.parseDouble(request.getParameter("price")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		product.setDescription(request.getParameter("description"));
		product.setImage(request.getParameter("image"));
		
		int result = productService.createProduct(product);
		
		if (result == 0) {
			request.setAttribute("add", "failure");
		}
		else {
			request.setAttribute("add", "success");
		}
		
		readAllProducts(request, response);

	}	

	public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Product product = new Product();
		product.setProductId(Integer.parseInt(request.getParameter("id")));
		product.setBrand(request.getParameter("brand"));
		product.setName(request.getParameter("name"));
		product.setPrice(Double.parseDouble(request.getParameter("price")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		product.setDescription(request.getParameter("description"));
		product.setImage(request.getParameter("image"));
		
		int result = productService.updateProduct(product);
		
		if (result == 0) {
			request.setAttribute("update", "failure");
		}
		else {
			request.setAttribute("update", "success");
		}
		
		readAllProducts(request, response);

	}

	public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		try {
			productService.deleteProduct(productId);
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("delete", "success");
		readAllProducts(request, response);

	}

}

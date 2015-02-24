package com.mindteck.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.businesslayer.DataDeletionException;
import com.mindteck.businesslayer.ProductService;
import com.mindteck.entities.Product;

public class ProductController {

	private ProductService productService = new ProductService();

	public void readAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> productList = productService.readAllProducts();
		PrintWriter out = response.getWriter();
		for (Product p : productList) {
			out.println(p + "<br /><br />");
		}
		
		// KEEP THIS - IT IS THE CORRECT VERSION. THE ABOVE IS FOR TESTING ONLY
		/*
		request.setAttribute("productList", productService.readAllProducts());	
		RequestDispatcher view = request.getRequestDispatcher("jsp/product.jsp");
		view.forward(request, response);
		*/
	}
	
	public void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createProduct(request, response);
		
		// KEEP THIS - IT IS THE CORRECT VERSION. THE ABOVE IS FOR TESTING ONLY
		/*
		RequestDispatcher view = request.getRequestDispatcher("jsp/productForm.jsp");
		view.forward(request, response);
		*/
	}
	
	public void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		product.setBrand(request.getParameter("brand"));
		product.setName(request.getParameter("name"));
		product.setCategory(request.getParameter("category"));
		product.setSubcategory(request.getParameter("subcategory"));
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
	
	public void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		updateProduct(request, response);
		
		// KEEP THIS - IT IS THE CORRECT VERSION. THE ABOVE IS FOR TESTING ONLY
		/*
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = productService.readProduct(productId);
		request.setAttribute("brand", product.getBrand());
		request.setAttribute("name", product.getName());
		request.setAttribute("category", product.getCategory());
		request.setAttribute("subcategory", product.getSubcategory());
		request.setAttribute("price", product.getPrice());
		request.setAttribute("quantity", product.getQuantity());
		request.setAttribute("description", product.getDescription());
		request.setAttribute("image", product.getImage());

		RequestDispatcher view = request.getRequestDispatcher("jsp/productForm.jsp");
		view.forward(request, response);
		*/
	}

	public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Product product = new Product();
		product.setProductId(Integer.parseInt(request.getParameter("id")));
		product.setBrand(request.getParameter("brand"));
		product.setName(request.getParameter("name"));
		product.setCategory(request.getParameter("category"));
		product.setSubcategory(request.getParameter("subcategory"));
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
			request.setAttribute("delete", "success");
		} catch (DataDeletionException e) {
			request.setAttribute("delete", "failure");
		}
		finally {
			readAllProducts(request, response);
		}
	}

}

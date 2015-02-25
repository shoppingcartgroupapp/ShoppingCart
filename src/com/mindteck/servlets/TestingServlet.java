package com.mindteck.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestingServlet")
public class TestingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TestingServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerController customerController = new CustomerController();
		SupplierController supplierController = new SupplierController();
		ProductController productController = new ProductController();
		String action = request.getParameter("action");
		
		if (action.contains("Customer")) {
			if (action.equals("addCustomer")) {
				customerController.createCustomer(request, response);
			}
			else if (action.equals("editCustomer")) {
				customerController.editCustomer(request, response);
			}
			else if (action.equals("deleteCustomer")) {
				customerController.deleteCustomer(request, response);
			}
			else if (action.equals("readAllCustomers")) {
				customerController.readAllCustomers(request, response);	
			}
		}
		else if (action.contains("Supplier")) {
			if (action.equals("addSupplier")) {
				supplierController.addSupplier(request, response);
			}
			else if (action.equals("deleteSupplier")) {
				supplierController.deleteSupplier(request, response);
			}
			else if (action.equals("editSupplier")) {
				supplierController.editSupplier(request, response);
			}
			else if (action.equals("readAllSuppliers")) {
				supplierController.readAllSuppliers(request, response);	
			}
		}
		else if (action.contains("Product")) {
			if (action.equals("addProduct")) {
				productController.addProduct(request, response);
			}
			else if (action.equals("deleteProduct")) {
				productController.deleteProduct(request, response);
			}
			else if (action.equals("editProduct")) {
				productController.editProduct(request, response);
			}
			else if (action.equals("readAllProducts")) {
				productController.readAllProducts(request, response);	
			}
		}
	}

}

package com.mindteck.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.contains("customer")) {

			CustomerController customerController = new CustomerController();

			if (action.equals("customer")) {
				customerController.readAllCustomers(request, response);
			}

			else if (action.equals("addcustomer")) {
				customerController.addCustomer(request, response);
			}

			else if (action.equals("createcustomer")) {
				customerController.createCustomer(request, response);
			}
			
			else if (action.equals("editcustomer")) {
				customerController.editCustomer(request, response);
			}

			else if (action.equals("updatecustomer")) {
				customerController.updateCustomer(request, response);
			}

			else if (action.equals("deletecustomer")) {
				customerController.readAllCustomers(request, response);
			}
		}
		
		if (action.contains("supplier")) {

			SupplierController supplierController = new SupplierController();

			if (action.equals("supplier")) {
				supplierController.readAllSuppliers(request, response);
			}

			else if (action.equals("addsupplier")) {
				supplierController.addSupplier(request, response);
			}

			else if (action.equals("createsupplier")) {
				supplierController.createSupplier(request, response);
			}

			else if (action.equals("editsupplier")) {
				supplierController.editSupplier(request, response);
			}

			else if (action.equals("updatesupplier")) {
				supplierController.updateSupplier(request, response);
			}

			else if (action.equals("deletesupplier")) {
				supplierController.readAllSuppliers(request, response);
			}
		}
		
		if (action.contains("account")) {
			
			if (action.equals("verifyaccount")) {
				
				if (request.getParameter("accountType").equals("customer")) {
					CustomerController customerController = new CustomerController();
					customerController.verifyCustomer(request, response);
				}
				
				else if (request.getParameter("accountType").equals("supplier")) {
					SupplierController supplierController = new SupplierController();
					supplierController.verifySupplier(request, response);
				}
			}
			
			else if (action.equals("logoutaccount")) {
				request.getSession().invalidate();
				RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
				view.forward(request, response);
			}
			
		}
		
		if (action.contains("product")) {

			ProductController productController = new ProductController();

			if (action.equals("product")) {
				productController.readAllProducts(request, response);
			}

			else if (action.equals("addproduct")) {
				productController.addProduct(request, response);
			}

			else if (action.equals("createproduct")) {
				productController.createProduct(request, response);
			}

			else if (action.equals("editproduct")) {
				productController.editProduct(request, response);
			}

			else if (action.equals("updateproduct")) {
				productController.updateProduct(request, response);
			}

			else if (action.equals("deleteproduct")) {
				productController.readAllProducts(request, response);
			}
		}

	}

}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DB Test</title>
</head>
<body>

<h1>SUPPLIER</h1>
	<form method="POST" action="/ShoppingCart/TestingServlet">
		<input type="hidden" name="action" value="readAllSuppliers" />
		<input type="submit" value="View All Suppliers" />
	</form>
<br />----------------------------------------------------------------------------------------------------<br />
	<form method="POST" action="/ShoppingCart/TestingServlet">
		<input type="hidden" name="action" value="deleteSupplier" />
		<table>
			<tr>
				<th colspan="2">Delete Supplier</th>
			</tr>
			<tr>
				<td>Supplier ID</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
<br />----------------------------------------------------------------------------------------------------<br />
	<form method="POST" action="/ShoppingCart/TestingServlet">
		<input type="hidden" name="action" value="editSupplier" />
		<table>
			<tr>
				<th colspan="2">Edit Supplier</th>
			</tr>
			<tr>
				<td>Supplier ID</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
<br />----------------------------------------------------------------------------------------------------<br />
	<form method="POST" action="/ShoppingCart/TestingServlet">
		<input type="hidden" name="action" value="addSupplier" />
		<table>
			<tr>
				<th colspan="2">Add Supplier</th>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	
<h1>CUSTOMER</h1>
	<form method="POST" action="/ShoppingCart/TestingServlet">
		<input type="hidden" name="action" value="readAllCustomers" />
		<input type="submit" value="View All Customers" />
	</form>
<br />----------------------------------------------------------------------------------------------------<br />
	<form method="POST" action="/ShoppingCart/TestingServlet">
		<input type="hidden" name="action" value="deleteCustomer" />
		<table>
			<tr>
				<th colspan="2">Delete Customer</th>
			</tr>
			<tr>
				<td>Customer ID</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
<br />----------------------------------------------------------------------------------------------------<br />
	<form method="POST" action="/ShoppingCart/TestingServlet">
		<input type="hidden" name="action" value="editCustomer" />
		<table>
			<tr>
				<th colspan="2">Edit Customer</th>
			</tr>
			<tr>
				<td>Customer ID</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="first_name" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="last_name" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><input type="text" name="dob" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
<br />----------------------------------------------------------------------------------------------------<br />
	<form method="POST" action="/ShoppingCart/TestingServlet">
		<input type="hidden" name="action" value="addCustomer" />
		<table>
			<tr>
				<th colspan="2">Add Customer</th>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><input type="text" name="dob" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
<br />----------------------------------------------------------------------------------------------------<br />

<h1>Product</h1>
	<form method="POST" action="/ShoppingCart/TestingServlet">
		<input type="hidden" name="action" value="readAllProducts" />
		<input type="submit" value="View All Products" />
	</form>
<br />----------------------------------------------------------------------------------------------------<br />
	<form method="POST" action="/ShoppingCart/TestingServlet">
		<input type="hidden" name="action" value="deleteProduct" />
		<table>
			<tr>
				<th colspan="2">Delete Product</th>
			</tr>
			<tr>
				<td>Product ID</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
<br />----------------------------------------------------------------------------------------------------<br />
	<form method="POST" action="/ShoppingCart/TestingServlet">
		<input type="hidden" name="action" value="editProduct" />
		<table>
			<tr>
				<th colspan="2">Edit Product</th>
			</tr>
			<tr>
				<td>Product ID</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Brand</td>
				<td><input type="text" name="brand" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="text" name="quantity" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>Image</td>
				<td><input type="text" name="image" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
<br />----------------------------------------------------------------------------------------------------<br />
	<form method="POST" action="/ShoppingCart/TestingServlet">
		<input type="hidden" name="action" value="addProduct" />
		<table>
			<tr>
				<th colspan="2">Add Product</th>
			</tr>
			<tr>
				<td>Brand</td>
				<td><input type="text" name="brand" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="text" name="quantity" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>Image</td>
				<td><input type="text" name="image" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
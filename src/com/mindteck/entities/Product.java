package com.mindteck.entities;

public class Product {
	
	private int productId;
	private String brand;
	private String name;
	private String category;
	private String subcategory;
	private double price;
	private int quantity;
	private String description;
	private String image;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", brand=" + brand
				+ ", name=" + name + ", price=" + price + ", quantity="
				+ quantity + ", description=" + description + ", image="
				+ image + "]";
	}

	public String simpleToString() {
		return this.productId + " " + this.brand + " " + this.name;
	}
	
}

package ZeptoCouponSystem.entities;

import java.util.UUID;

public class Product {

	final String productId;
	final String productName;
	final String productCategory;
	final double productPrice;

	public Product(String name, String category, double price) {
		this.productId = UUID.randomUUID().toString();
		this.productName = name;
		this.productCategory = category;
		this.productPrice = price;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public double getProductPrice() {
		return productPrice;
	}

}

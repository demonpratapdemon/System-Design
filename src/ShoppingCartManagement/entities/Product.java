package ShoppingCartManagement.entities;

import java.util.UUID;

public class Product {
	private String productId;
	private String productName;
	private double price;

	public Product(String productName, double price) {
		this.productId = UUID.randomUUID().toString();
		this.productName = productName;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}

}

package ShoppingCartManagement.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Cart {
	private String cartId;
	private String customerName;
	Map<String, CartItem> items = new HashMap<>(); // ProductID - CartItem

	public Cart(String customerName) {
		this.cartId = UUID.randomUUID().toString();
		this.customerName = customerName;
	}

	public String getCartId() {
		return cartId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Map<String, CartItem> getItems() {
		return items;
	}

	public double getTotal() {
		return items.values().stream().mapToDouble(CartItem::getTotal).sum();
	}

}

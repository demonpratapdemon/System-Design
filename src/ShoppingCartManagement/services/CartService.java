package ShoppingCartManagement.services;

import java.util.HashMap;
import java.util.Map;

import ShoppingCartManagement.entities.Cart;
import ShoppingCartManagement.entities.CartItem;
import ShoppingCartManagement.entities.Product;

public class CartService {

	private Map<String, Cart> carts = new HashMap<>();
	private Map<String, Product> products = new HashMap<>();

	public CartService(Map<String, Product> products) {
		this.products = products;
	}

	public Cart createCart(String customerName) {
		Cart cart = new Cart(customerName);
		carts.put(cart.getCartId(), cart);
		return cart;
	}

	public void addProduct(String cartId, String pdtId, int qty) {
		Cart c = carts.get(cartId);
		Product p = products.get(pdtId);
		if (c == null || p == null)
			return;
		c.getItems().merge(pdtId, new CartItem(p, qty), (oldItem, newItem) -> {
			int newQty = oldItem.getQuantity() + newItem.getQuantity();
			return new CartItem(p, newQty);
		});
	}

	public void removeProduct(String cartId, String pdtId) {
		Cart c = carts.get(cartId);
		if (c != null)
			c.getItems().remove(pdtId);
	}

	public Cart viewCart(String cartId) {
		return carts.get(cartId);
	}

	public void clearCart(String cartId) {
		Cart c = carts.get(cartId);
		if (c != null)
			c.getItems().clear();
	}
}

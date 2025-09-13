package ZeptoCouponSystem.entities;

import java.util.List;
import java.util.UUID;

public class Cart {

	private String cartId;
	private List<CartItem> items;

	public Cart(List<CartItem> items) {
		this.cartId = UUID.randomUUID().toString();
		this.items = items;
	}

	public String getCartId() {
		return cartId;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public double getTotal() {
		return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
	}

	public boolean hasCategory(String category) {
		return items.stream().anyMatch(p -> p.getProduct().getProductCategory().equalsIgnoreCase(category));
	}

	@Override
	public String toString() {
		String str = "Cart [cartId=" + cartId;
		for (CartItem item : items) {
			str += ", (Item = " + item.getProduct().getProductName() + ", Quantity = " + item.getQuantity()
					+ ", Price = " + item.getProduct().getProductPrice() + ")";
		}
		return str;
	}

}

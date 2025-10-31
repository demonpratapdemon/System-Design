package FoodDeliverySystem.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
	private String cartId;
	private User user;
	private Restaurant restaurant;
	private List<CartItem> items;

	public Cart(User user) {
		this.cartId = UUID.randomUUID().toString();
		this.user = user;
		this.items = new ArrayList<CartItem>();
	}

	public void addItem(Restaurant restaurant, MenuItem menuItem, int quantity) {
		if (this.restaurant == null) {
			this.restaurant = restaurant;
		} else if (this.restaurant != restaurant) {
			throw new IllegalStateException("You can only add items from one restaurant at a time!");
		}

		for (CartItem cartItem : items) {
			if (cartItem.getMenuItem().equals(menuItem)) {
				cartItem.increaseQuantity(quantity);
				return;
			}
		}

		items.add(new CartItem(menuItem, quantity));
	}

	public void removeItem(MenuItem menuItem) {
		items.removeIf(i -> i.getMenuItem().equals(menuItem));
	}

	public void clearCart() {
		items.clear();
		restaurant = null;
	}

	public double getOrderTotal() {
		return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
	}

	public List<CartItem> getItems() {
		return items;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public String getCartId() {
		return cartId;
	}

	public User getUser() {
		return user;
	}

}

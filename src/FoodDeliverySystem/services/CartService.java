package FoodDeliverySystem.services;

import java.util.HashMap;
import java.util.Map;

import FoodDeliverySystem.entities.Cart;
import FoodDeliverySystem.entities.MenuItem;
import FoodDeliverySystem.entities.Restaurant;
import FoodDeliverySystem.entities.User;

public class CartService {
	Map<String, Cart> userCarts = new HashMap<>();

	public Cart getCart(User user) {
		return userCarts.computeIfAbsent(user.getUserId(), f -> new Cart(user));
	}

	public void addItem(User user, Restaurant restaurant, MenuItem menuItem, int qty) {
		Cart cart = getCart(user);
		cart.addItem(restaurant, menuItem, qty);
		System.out.println(qty + " x " + menuItem.getMenuName() + " added to cart.");
	}

	public void removeItem(User user, MenuItem menuItem) {
		Cart cart = userCarts.get(user.getUserId());
		cart.removeItem(menuItem);
		System.out.println(menuItem.getMenuName() + " removed from cart.");
	}

	public void clearCart(User user) {
		getCart(user).clearCart();
	}

	public double checkoutCart(User user) {
		Cart cart = getCart(user);
		double total = cart.getOrderTotal();
		System.out.println("Cart total for " + user.getUserName() + ": " + total);
		return total;
	}
}

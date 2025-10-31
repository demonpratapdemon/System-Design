package FoodDeliverySystem.entities;

public class CartItem {
	private MenuItem menuItem;
	private int quantity;

	public CartItem(MenuItem menuItem, int quantity) {
		this.menuItem = menuItem;
		this.quantity = quantity;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void increaseQuantity(int qty) {
		this.quantity += qty;
	}

	public void decreaseQuantity(int qty) {
		this.quantity = Math.max(1, this.quantity - qty);
	}

	public double getTotalPrice() {
		return menuItem.getPrice() * quantity;
	}
}

package FoodDeliverySystem.entities;

import java.util.UUID;

public class MenuItem {
	private String menuId;
	private String menuName;
	private double price;

	public MenuItem(String menuName, double price) {
		this.menuId = UUID.randomUUID().toString();
		this.menuName = menuName;
		this.price = price;
	}

	public String getMenuId() {
		return menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public double getPrice() {
		return price;
	}

}

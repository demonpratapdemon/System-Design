package FoodDeliverySystem.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Restaurant {
	private String restId;
	private String restName;
	private double latitude;
	private double longitude;
	private List<MenuItem> menuItems;

	public Restaurant(String restName, double latitude, double longitude) {
		this.restId = UUID.randomUUID().toString();
		this.restName = restName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.menuItems = new ArrayList<MenuItem>();
	}

	public String getRestId() {
		return restId;
	}

	public String getRestName() {
		return restName;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void addMenuItem(MenuItem item) {
		this.menuItems.add(item);
	}
}

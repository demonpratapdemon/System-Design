package FoodDeliverySystem.entities;

import java.util.List;
import java.util.UUID;

import FoodDeliverySystem.enums.OrderStatus;

public class Order {
	private String orderId;
	private User user;
	private DeliveryAgent agent;
	private Restaurant restaurant;
	private List<MenuItem> items;
	private OrderStatus orderStatus;
	private Payment payment;

	public Order(User user, Restaurant restaurant, List<MenuItem> items) {
		this.orderId = UUID.randomUUID().toString();
		this.user = user;
		this.restaurant = restaurant;
		this.items = items;
		this.orderStatus = OrderStatus.PLACED;
	}

	public String getOrderId() {
		return orderId;
	}

	public User getUser() {
		return user;
	}

	public DeliveryAgent getAgent() {
		return agent;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public List<MenuItem> getItems() {
		return items;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setAgent(DeliveryAgent agent) {
		this.agent = agent;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	
	
}

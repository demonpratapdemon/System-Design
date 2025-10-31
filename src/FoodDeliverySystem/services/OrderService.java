package FoodDeliverySystem.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import FoodDeliverySystem.entities.Cart;
import FoodDeliverySystem.entities.CartItem;
import FoodDeliverySystem.entities.MenuItem;
import FoodDeliverySystem.entities.Order;
import FoodDeliverySystem.entities.Payment;
import FoodDeliverySystem.entities.User;
import FoodDeliverySystem.enums.OrderStatus;
import FoodDeliverySystem.enums.PaymentStatus;

public class OrderService {
	private Map<String, Order> orders;
	private DeliveryService deliveryService;
	private PaymentService paymentService;

	public OrderService(DeliveryService deliveryService, PaymentService paymentService) {
		this.orders = new HashMap<String, Order>();
		this.deliveryService = deliveryService;
		this.paymentService = paymentService;
	}

	public Order placeOrder(User user, Cart cart, Payment payment) {
		List<MenuItem> menuItems = new ArrayList<>();
		for (CartItem item : cart.getItems()) {
			for (int i = 0; i < item.getQuantity(); i++) {
				menuItems.add(item.getMenuItem());
			}
		}
		Order order = new Order(user, cart.getRestaurant(), menuItems);
		orders.put(order.getOrderId(), order);
		System.out.println("Order placed: " + order.getOrderId() + " by " + user.getUserName() + " and the amount is : " + cart.getOrderTotal());
		paymentService.processPayment(payment);

		if (payment.getPaymentStatus() == PaymentStatus.SUCCESS) {
			order.setOrderStatus(OrderStatus.PLACED);
			deliveryService.assignAgentToOrder(order);
			cart.clearCart();
		} else {
			order.setOrderStatus(OrderStatus.CANCELLED);
			System.out.println("Payment failed. Order " + order.getOrderId() + " cancelled.");
		}
		return order;
	}

	public void markOrderDelivered(String orderId) {
		Order order = this.orders.get(orderId);
		if (order != null) {
			deliveryService.markDelivered(orderId);
			order.setOrderStatus(OrderStatus.DELIVERED);
			System.out.println("Order " + orderId + " marked as delivered.");
		}
	}
}

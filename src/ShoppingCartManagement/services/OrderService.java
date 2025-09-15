package ShoppingCartManagement.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ShoppingCartManagement.entities.Cart;
import ShoppingCartManagement.entities.Order;
import ShoppingCartManagement.enums.OrderStatus;

public class OrderService {
	private Map<String, Order> orders = new HashMap<String, Order>();

	public Order checkout(Cart c) {
		if (c.getItems().size() == 0)
			return null;
		Order order = new Order(c.getCustomerName(), new ArrayList<>(c.getItems().values()));
		orders.put(order.getOrderId(), order);
		c.getItems().clear();
		return order;
	}

	public Order getOrder(String orderId) {
		return orders.get(orderId);
	}

	public void updateStatus(String orderId, OrderStatus status) {
		Order o = orders.get(orderId);
		if (o == null)
			return;
		if (o.getOrderStatus() == OrderStatus.DElIVERED || o.getOrderStatus() == OrderStatus.CANCELLED)
			return;
		o.setOrderStatus(status);
	}

	public void cancelOrder(String orderId) {
		Order o = orders.get(orderId);
		if (o != null && o.getOrderStatus() != OrderStatus.DElIVERED)
			o.setOrderStatus(OrderStatus.CANCELLED);
	}

	public List<Order> listOrders() {
		return new ArrayList<>(orders.values());
	}
}

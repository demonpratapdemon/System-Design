package ShoppingCartManagement.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import ShoppingCartManagement.enums.OrderStatus;

public class Order {
	private String orderId;
	private String customerName;
	private OrderStatus orderStatus;
	private Date createdAt;
	private List<CartItem> items;

	public Order(String customerName, List<CartItem> items) {
		this.orderId = UUID.randomUUID().toString();
		this.customerName = customerName;
		this.items = items;
		this.orderStatus = OrderStatus.NEW;
		this.createdAt = new Date();
	}

	public double getTotal() {
		return items.stream().mapToDouble(CartItem::getTotal).sum();
	}

	public String getOrderId() {
		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", orderStatus=" + orderStatus
				+ ", createdAt=" + createdAt + ", items=" + items + "]";
	}

}

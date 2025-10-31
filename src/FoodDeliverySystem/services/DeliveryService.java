package FoodDeliverySystem.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import FoodDeliverySystem.delivery_strategy.interfaces.DeliveryAssignmentStrategy;
import FoodDeliverySystem.entities.DeliveryAgent;
import FoodDeliverySystem.entities.Order;
import FoodDeliverySystem.enums.OrderStatus;

public class DeliveryService {
	private List<DeliveryAgent> deliveryAgents;
	private DeliveryAssignmentStrategy assignmentStrategy;
	private Map<String, DeliveryAgent> activeDeliveries;

	public DeliveryService(DeliveryAssignmentStrategy assignmentStrategy) {
		this.deliveryAgents = new ArrayList<DeliveryAgent>();
		this.assignmentStrategy = assignmentStrategy;
		this.activeDeliveries = new HashMap<String, DeliveryAgent>();
	}

	public void registerAgent(DeliveryAgent agent) {
		this.deliveryAgents.add(agent);
	}

	public boolean assignAgentToOrder(Order order) {
		DeliveryAgent agent = assignmentStrategy.assignDeliveryAgent(order, deliveryAgents);
		if (agent != null) {
			order.setOrderStatus(OrderStatus.ASSIGNED);
			order.setAgent(agent);
			this.activeDeliveries.put(order.getOrderId(), agent);
			System.out.println("Assigned " + agent.getAgentName() + " to order " + order.getOrderId());
			return true;
		}
		return false;
	}

	public void markDelivered(String orderId) {
		DeliveryAgent agent = this.activeDeliveries.get(orderId);
		if (agent != null) {
			agent.setAvailable(true);
			System.out.println("Order " + orderId + " delivered by " + agent.getAgentName());
		}
	}

	public List<DeliveryAgent> getDeliveryAgents() {
		return deliveryAgents;
	}

}

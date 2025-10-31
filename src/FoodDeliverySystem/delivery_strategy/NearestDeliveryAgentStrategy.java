package FoodDeliverySystem.delivery_strategy;

import java.util.List;

import FoodDeliverySystem.delivery_strategy.interfaces.DeliveryAssignmentStrategy;
import FoodDeliverySystem.entities.DeliveryAgent;
import FoodDeliverySystem.entities.Order;
import FoodDeliverySystem.entities.Restaurant;

public class NearestDeliveryAgentStrategy implements DeliveryAssignmentStrategy {

	@Override
	public DeliveryAgent assignDeliveryAgent(Order order, List<DeliveryAgent> agents) {
		// TODO Auto-generated method stub
		DeliveryAgent nearest = null;
		double dist = Double.MAX_VALUE;

		for (DeliveryAgent agent : agents) {
			if (!agent.isAvailable())
				continue;
			double d = calculateDistance(order.getRestaurant(), agent);
			if (d < dist) {
				dist = d;
				nearest = agent;
			}
		}

		if (nearest != null) {
			nearest.setAvailable(false);
			System.out.println("Assigned nearest agent: " + nearest.getAgentName());
		}

		return nearest;
	}

	private double calculateDistance(Restaurant restaurant, DeliveryAgent agent) {
		// TODO Auto-generated method stub
		double dx = Math.abs(restaurant.getLatitude() - agent.getLatitude());
		double dy = Math.abs(restaurant.getLongitude() - agent.getLongitude());
		return Math.sqrt(dx * dx + dy * dy);
	}

}

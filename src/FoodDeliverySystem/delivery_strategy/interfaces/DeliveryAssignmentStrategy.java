package FoodDeliverySystem.delivery_strategy.interfaces;

import java.util.List;

import FoodDeliverySystem.entities.DeliveryAgent;
import FoodDeliverySystem.entities.Order;

public interface DeliveryAssignmentStrategy {
	DeliveryAgent assignDeliveryAgent(Order order, List<DeliveryAgent> agents);
}

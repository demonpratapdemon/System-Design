package FoodDeliverySystem;

import FoodDeliverySystem.delivery_strategy.NearestDeliveryAgentStrategy;
import FoodDeliverySystem.entities.Address;
import FoodDeliverySystem.entities.Cart;
import FoodDeliverySystem.entities.DeliveryAgent;
import FoodDeliverySystem.entities.MenuItem;
import FoodDeliverySystem.entities.Order;
import FoodDeliverySystem.entities.Payment;
import FoodDeliverySystem.entities.Restaurant;
import FoodDeliverySystem.entities.User;
import FoodDeliverySystem.enums.PaymentMethod;
import FoodDeliverySystem.enums.PaymentStatus;
import FoodDeliverySystem.services.CartService;
import FoodDeliverySystem.services.DeliveryService;
import FoodDeliverySystem.services.OrderService;
import FoodDeliverySystem.services.PaymentService;

public class FoodDeliveryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Restaurant rest = new Restaurant("Tandoori Express", 10.0, 20.0);
		rest.addMenuItem(new MenuItem("Paneer Tikka", 250));
		rest.addMenuItem(new MenuItem("Naan", 40));

		User user = new User("Adam", 1234567890, new Address("Bangalore", "KA", "560037"));
		DeliveryService deliveryService = new DeliveryService(new NearestDeliveryAgentStrategy());
		deliveryService.registerAgent(new DeliveryAgent("Ravi", 11.0, 21.5));
		deliveryService.registerAgent(new DeliveryAgent("Amit", 15.0, 25.0));

		PaymentService paymentService = new PaymentService();
		OrderService orderService = new OrderService(deliveryService, paymentService);

		Payment payment = new Payment(290, PaymentStatus.PENDING, PaymentMethod.UPI);

		CartService cartService = new CartService();
		cartService.addItem(user, rest, rest.getMenuItems().get(0), 2);
		cartService.addItem(user, rest, rest.getMenuItems().get(1), 3);

		Cart userCart = cartService.getCart(user);
		Order order = orderService.placeOrder(user, userCart, payment);
		orderService.markOrderDelivered(order.getOrderId());
	}

}

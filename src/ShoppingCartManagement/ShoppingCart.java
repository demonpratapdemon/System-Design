package ShoppingCartManagement;

import java.util.HashMap;
import java.util.Map;

import ShoppingCartManagement.entities.Cart;
import ShoppingCartManagement.entities.Order;
import ShoppingCartManagement.entities.Product;
import ShoppingCartManagement.enums.OrderStatus;
import ShoppingCartManagement.services.CartService;
import ShoppingCartManagement.services.OrderService;

public class ShoppingCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Product> products = new HashMap<>();
		products.put("1", new Product("Book", 200));
		products.put("2", new Product("Pen", 10));
		products.put("3", new Product("Laptop", 50000));

		CartService csv = new CartService(products);
		OrderService osv = new OrderService();

		Cart c1 = csv.createCart("Pratap");
		csv.addProduct(c1.getCartId(), "1", 2);
		csv.addProduct(c1.getCartId(), "2", 5);

		System.out.println("Cart Total : " + csv.viewCart(c1.getCartId()).getTotal());

		Order o1 = osv.checkout(c1);
		System.out.println("Order created : " + o1);

		osv.updateStatus(o1.getOrderId(), OrderStatus.CONFIRMED);
		System.out.println("After confirm : " + osv.getOrder(o1.getOrderId()));
		System.out.println("Order Price : " + o1.getTotal());
	}

}

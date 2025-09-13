package ZeptoCouponSystem;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import ZeptoCouponSystem.coupon_model.Coupon;
import ZeptoCouponSystem.coupon_model.CouponEngine;
import ZeptoCouponSystem.entities.Cart;
import ZeptoCouponSystem.entities.CartItem;
import ZeptoCouponSystem.entities.Product;
import ZeptoCouponSystem.entities.User;
import ZeptoCouponSystem.entities.UserType;
import ZeptoCouponSystem.rules.MinCartValueRule;
import ZeptoCouponSystem.rules.ProductCategoryRule;
import ZeptoCouponSystem.rules.UserTypeRule;

public class CouponSystemDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User("U1", UserType.PREMIUM);

		Product laptop = new Product("Laptop", "Electronics", 50000);
		Product shoes = new Product("Shoes", "Fashion", 2000);

		List<CartItem> items = Arrays.asList(new CartItem(laptop, 1), new CartItem(shoes, 2));

		Cart cart = new Cart(items);

		Coupon coupon1 = new Coupon("Electronics10", 1000, true, new Date(System.currentTimeMillis() + 86400000),
				Arrays.asList(new MinCartValueRule(1000), new ProductCategoryRule("Electronics")));

		Coupon coupon2 = new Coupon("PremiumDiscount", 1500, true, new Date(System.currentTimeMillis() + 86400000),
				Arrays.asList(new UserTypeRule(new HashSet<>(Arrays.asList(UserType.PREMIUM)))));

		CouponEngine cg = new CouponEngine(Arrays.asList(coupon1, coupon2));

		Optional<Coupon> bestCoupon = cg.getBestCoupon(user, cart);

		if (bestCoupon.isPresent()) {
			System.out.println("Best Coupon: " + bestCoupon.get().getCouponName() + " | Discount of :"
					+ bestCoupon.get().getDiscount());
			double finalPrice = cart.getTotal() - bestCoupon.get().getDiscount();
			System.out.println("Cart Item: " + cart.toString());
			System.out.println("Total price of cart : " + finalPrice);
		} else {
			System.out.println("No coupons applicable");
		}
	}

}

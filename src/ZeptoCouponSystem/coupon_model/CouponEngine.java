package ZeptoCouponSystem.coupon_model;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import ZeptoCouponSystem.entities.Cart;
import ZeptoCouponSystem.entities.User;

public class CouponEngine {

	private List<Coupon> activeCoupons;

	public CouponEngine(List<Coupon> activeCoupons) {
		this.activeCoupons = activeCoupons;
	}

	public Optional<Coupon> getBestCoupon(User user, Cart cart) {
		return activeCoupons.stream().filter(c -> c.isApplicable(user, cart))
				.max(Comparator.comparingDouble(Coupon::getDiscount));
	}
}

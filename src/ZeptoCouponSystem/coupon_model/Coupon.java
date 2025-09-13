package ZeptoCouponSystem.coupon_model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import ZeptoCouponSystem.entities.Cart;
import ZeptoCouponSystem.entities.User;
import ZeptoCouponSystem.rules.IRule;

public class Coupon {
	private String couponId;
	private String couponName;
	private double discount;
	private boolean active;
	private Date expiry;
	private List<IRule> rules;

	public Coupon(String couponName, double discount, boolean active, Date expiry, List<IRule> rules) {
		this.couponId = UUID.randomUUID().toString();
		this.couponName = couponName;
		this.discount = discount;
		this.active = active;
		this.expiry = expiry;
		this.rules = rules;
	}

	public String getCouponName() {
		return couponName;
	}

	public double getDiscount() {
		return discount;
	}

	public boolean isActive() {
		return active && expiry.after(new Date());
	}

	public boolean isApplicable(User user, Cart cart) {
		if (!isActive())
			return false;
		for (IRule rule : rules) {
			if (rule.isApplicable(user, cart))
				return true;
		}
		return false;
	}
}

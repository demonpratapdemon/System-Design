package ZeptoCouponSystem.rules;

import ZeptoCouponSystem.entities.Cart;
import ZeptoCouponSystem.entities.User;

public class MinCartValueRule implements IRule {

	private double threshold;

	public MinCartValueRule(double threshold) {
		this.threshold = threshold;
	}

	@Override
	public boolean isApplicable(User user, Cart cart) {
		// TODO Auto-generated method stub
		return cart.getTotal() >= threshold;
	}

}

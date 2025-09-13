package ZeptoCouponSystem.rules;

import ZeptoCouponSystem.entities.Cart;
import ZeptoCouponSystem.entities.User;

public interface IRule {
	boolean isApplicable(User user, Cart cart);
}

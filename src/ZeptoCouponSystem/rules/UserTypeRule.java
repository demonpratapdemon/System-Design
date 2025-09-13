package ZeptoCouponSystem.rules;

import java.util.Set;

import ZeptoCouponSystem.entities.Cart;
import ZeptoCouponSystem.entities.User;
import ZeptoCouponSystem.entities.UserType;

public class UserTypeRule implements IRule {

	private Set<UserType> allowedTypes;

	public UserTypeRule(Set<UserType> allowedTypes) {
		this.allowedTypes = allowedTypes;
	}

	@Override
	public boolean isApplicable(User user, Cart cart) {
		// TODO Auto-generated method stub
		return allowedTypes.contains(user.getUserType());
	}

}

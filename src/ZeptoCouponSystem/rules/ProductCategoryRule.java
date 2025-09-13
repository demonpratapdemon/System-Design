package ZeptoCouponSystem.rules;

import ZeptoCouponSystem.entities.Cart;
import ZeptoCouponSystem.entities.User;

public class ProductCategoryRule implements IRule {
	private String category;

	public ProductCategoryRule(String category) {
		this.category = category;
	}

	@Override
	public boolean isApplicable(User user, Cart cart) {
		// TODO Auto-generated method stub
		return cart.hasCategory(category);
	}

}

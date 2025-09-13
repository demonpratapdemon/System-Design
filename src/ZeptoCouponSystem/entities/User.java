package ZeptoCouponSystem.entities;

import java.util.UUID;

public class User {

	final String userId;
	final String userName;
	final UserType userType;

	public User(String name, UserType userType) {
		this.userId = UUID.randomUUID().toString();
		this.userName = name;
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public UserType getUserType() {
		return userType;
	}

	
}

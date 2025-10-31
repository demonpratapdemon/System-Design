package FoodDeliverySystem.entities;

import java.util.UUID;

public class User {
	private String userId;
	private String userName;
	private long userNumber;
	private Address address;

	public User(String userName, long userNumber, Address address) {
		this.userId = UUID.randomUUID().toString();
		this.userName = userName;
		this.userNumber = userNumber;
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public long getUserNumber() {
		return userNumber;
	}

	public Address getAddress() {
		return address;
	}

}

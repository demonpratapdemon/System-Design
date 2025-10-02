package UPIPaymentSystem.entities;

import java.util.UUID;

public class User {
	private String userId;
	private String userName;
	private String upiId;

	public User(String userName, String upiId) {
		this.userId = UUID.randomUUID().toString();
		this.userName = userName;
		this.upiId = upiId;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUpiId() {
		return upiId;
	}

}

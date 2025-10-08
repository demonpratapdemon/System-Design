package ATMMachine.entities;

import java.util.UUID;

public class User {
	private final String userId;
	private final String userName;
	private final BankAccount account;

	public User(String userName, BankAccount account) {
		this.userId = UUID.randomUUID().toString();
		this.userName = userName;
		this.account = account;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public BankAccount getAccount() {
		return account;
	}

}

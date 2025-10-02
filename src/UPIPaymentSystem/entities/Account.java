package UPIPaymentSystem.entities;

import java.math.BigDecimal;
import java.util.UUID;

public class Account {
	private String accountId;
	private User user;
	private BigDecimal balance;
	private int version; // for optimistic locking

	public Account(User user, BigDecimal balance) {
		this.accountId = UUID.randomUUID().toString();
		this.user = user;
		this.balance = balance;
		this.version = 0;
	}

	public String getAccountId() {
		return accountId;
	}

	public User getUser() {
		return user;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public int getVersion() {
		return version;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}

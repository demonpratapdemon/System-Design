package ATMMachine.entities;

import java.util.UUID;

public class BankAccount {
	private final String accountNo;
	private final Card card;
	private double balance;

	public BankAccount(Card card, double balance) {
		this.accountNo = UUID.randomUUID().toString();

		this.card = card;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public Card getCard() {
		return card;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public boolean canWithdraw(double amount) {
		return amount <= balance;
	}

	public boolean withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			return true;
		}
		return false;
	}
}

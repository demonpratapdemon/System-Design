package UPIPaymentSystem.services;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import UPIPaymentSystem.entities.Account;
import UPIPaymentSystem.entities.User;

public class AccountService {
	private final Map<String, Account> accounts;

	public AccountService() {
		this.accounts = new ConcurrentHashMap<String, Account>();
	}

	public void addAccount(Account account) {
		accounts.put(account.getUser().getUserId(), account);
	}

	public Account getAccount(User user) {
		return accounts.get(user.getUserId());
	}

	public boolean transferAmount(Account from, Account to, BigDecimal amt, String txnId) {
		synchronized (from) {
			synchronized (to) {
				if (from.getBalance().compareTo(amt) < 0)
					return false;
				from.setBalance(from.getBalance().subtract(amt));
				to.setBalance(to.getBalance().add(amt));
				return true;
			}
		}
	}
}

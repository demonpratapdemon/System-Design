package ATMMachine.services;

import java.util.Map;

import ATMMachine.entities.BankAccount;
import ATMMachine.entities.Card;
import ATMMachine.inventory.CashInventory;

public class ATMService {
	private CardService cardService;
	private final CashInventory cashInventory;

	public ATMService(CardService cardService, CashInventory cashInventory) {
		this.cardService = cardService;
		this.cashInventory = cashInventory;
	}

	public void checkBalance(Card card) {
		// TODO Auto-generated method stub
		System.out.println("Balance: " + cardService.getBankAccountByCard(card).getBalance());
	}

	public void withdraw(Card card, double amount) {
		// TODO Auto-generated method stub
		BankAccount account = cardService.getBankAccountByCard(card);

		if (account == null) {
			System.out.println("No account linked to this card.");
			return;
		}

		if (!account.canWithdraw(amount)) {
			System.out.println("Insufficient Balance");
			return;
		}

		if (!cashInventory.hasSufficientCash((int) amount)) {
			System.out.println("ATM has insufficient cash");
			return;
		}

		Map<Integer, Integer> dispensedCash = cashInventory.dispenseCash((int) amount);

		if (dispensedCash.isEmpty()) {
			System.out.println("Cannot dispense cash with available denominations");
			return;
		}

		account.withdraw(amount);
		System.out.println("Dispensed: " + dispensedCash);
		System.out.println("Remaining Balance: " + account.getBalance());
	}

	public void deposit(Card card, double amount, int denom, int count) {
		// TODO Auto-generated method stub
		BankAccount account = cardService.getBankAccountByCard(card);
		account.deposit(amount);
		cashInventory.addCash(denom, count);
		System.out.println("Balance after Deposit: " + account.getBalance());
	}

}

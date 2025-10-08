package ATMMachine.services;

import java.util.HashMap;
import java.util.Map;

import ATMMachine.entities.BankAccount;
import ATMMachine.entities.Card;

public class CardService {
	private final Map<Card, BankAccount> cardToAccount = new HashMap<Card, BankAccount>();

	public void linkCard(Card card, BankAccount account) {
		cardToAccount.put(card, account);
	}

	public BankAccount getBankAccountByCard(Card card) {
		return cardToAccount.getOrDefault(card, null);
	}
}

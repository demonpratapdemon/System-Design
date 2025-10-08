package ATMMachine;

import ATMMachine.entities.ATM;
import ATMMachine.entities.BankAccount;
import ATMMachine.entities.Card;
import ATMMachine.entities.User;
import ATMMachine.enums.TransactionType;
import ATMMachine.inventory.CashInventory;
import ATMMachine.services.ATMService;
import ATMMachine.services.CardService;

public class ATMDriverCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card card = new Card("CARD123", "1234");
		BankAccount account = new BankAccount(card, 1000.0);
		User user = new User("pratapc", account);

		CashInventory atmInventory = new CashInventory();
		atmInventory.addCash(2000, 5);
		atmInventory.addCash(500, 10);
		atmInventory.addCash(100, 20);
		
		CardService cardService = new CardService();
		cardService.linkCard(card, account);
		
		ATMService atmService = new ATMService(cardService, atmInventory);
		ATM atm = new ATM(atmService);
		
		atm.insertCard(user.getAccount().getCard());
		atm.enterPin("1234");
		atm.selectTransaction(TransactionType.BALANCE_ENQUIRY, 0);
		
		atm.insertCard(user.getAccount().getCard());
		atm.enterPin("1234");
		atm.selectTransaction(TransactionType.WITHDRAW, 500);
		
		atm.insertCard(user.getAccount().getCard());
		atm.enterPin("1234");
		atm.selectTransaction(TransactionType.DEPOSIT, 600);
	}

}

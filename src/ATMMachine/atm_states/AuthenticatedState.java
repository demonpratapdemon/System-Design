package ATMMachine.atm_states;

import ATMMachine.entities.ATM;
import ATMMachine.entities.Card;
import ATMMachine.enums.TransactionType;
import ATMMachine.services.ATMService;

public class AuthenticatedState implements ATMState {

	@Override
	public void insertCard(ATM atm, Card card) {
		// TODO Auto-generated method stub
		System.out.println("ATM Card already inserted.");
	}

	@Override
	public void enterPin(ATM atm, String pin) {
		// TODO Auto-generated method stub
		System.out.println("ATM Card PIN already verified.");
	}

	@Override
	public void selectTransaction(ATM atm, TransactionType type, double amount) {
		// TODO Auto-generated method stub
		ATMService atmService = atm.getAtmService();
		switch (type) {
		case BALANCE_ENQUIRY: {
			atmService.checkBalance(atm.getCard());
			break;
		}
		case DEPOSIT: {
			atmService.deposit(atm.getCard(), amount, 500, (int) (amount / 500));
			break;
		}
		case WITHDRAW: {
			atmService.withdraw(atm.getCard(), amount);
			break;
		}
		}
		System.out.println("Transaction Complete. Ejecting card.");
		ejectCard(atm);
	}

	@Override
	public void ejectCard(ATM atm) {
		// TODO Auto-generated method stub
		System.out.println("ATM Card ejected.");
		atm.setCard(null);
		atm.setCurrState(new IdleState());
	}

}

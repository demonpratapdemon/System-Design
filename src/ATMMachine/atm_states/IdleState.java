package ATMMachine.atm_states;

import ATMMachine.entities.ATM;
import ATMMachine.entities.Card;
import ATMMachine.enums.TransactionType;

public class IdleState implements ATMState {

	@Override
	public void insertCard(ATM atm, Card card) {
		// TODO Auto-generated method stub
		atm.setCard(card);
		System.out.println("ATM card is inserted. Please enter pin.");
		atm.setCurrState(new CardInsertedState());
	}

	@Override
	public void enterPin(ATM atm, String pin) {
		// TODO Auto-generated method stub
		System.out.println("Insert ATM Card first.");
	}

	@Override
	public void selectTransaction(ATM atm, TransactionType type, double amount) {
		// TODO Auto-generated method stub
		System.out.println("Insert ATM Card first.");
	}

	@Override
	public void ejectCard(ATM atm) {
		// TODO Auto-generated method stub
		System.out.println("No ATM Card to eject.");
	}

}

package ATMMachine.atm_states;

import ATMMachine.entities.ATM;
import ATMMachine.entities.Card;
import ATMMachine.enums.TransactionType;

public class CardInsertedState implements ATMState {

	@Override
	public void insertCard(ATM atm, Card card) {
		// TODO Auto-generated method stub
		System.out.println("ATM Card already inserted.");
	}

	@Override
	public void enterPin(ATM atm, String pin) {
		// TODO Auto-generated method stub
		if (atm.getCard().getPin().equals(pin)) {
			System.out.println("PIN verified. Select Transaction");
			atm.setCurrState(new AuthenticatedState());
		} else {
			System.out.println("Entered PIN is incorrect. Ejecting ATM card");
			ejectCard(atm);
		}
	}

	@Override
	public void selectTransaction(ATM atm, TransactionType type, double amount) {
		// TODO Auto-generated method stub
		System.out.println("Enter PIN first.");
	}

	@Override
	public void ejectCard(ATM atm) {
		// TODO Auto-generated method stub
		System.out.println("ATM Card ejected.");
		atm.setCard(null);
		atm.setCurrState(new IdleState());
	}

}

package ATMMachine.atm_states;

import ATMMachine.entities.ATM;
import ATMMachine.entities.Card;
import ATMMachine.enums.TransactionType;

public interface ATMState {
	void insertCard(ATM atm, Card card);

	void enterPin(ATM atm, String pin);

	void selectTransaction(ATM atm, TransactionType type, double amount);

	void ejectCard(ATM atm);
}

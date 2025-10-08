package ATMMachine.entities;

import ATMMachine.atm_states.ATMState;
import ATMMachine.atm_states.IdleState;
import ATMMachine.enums.TransactionType;
import ATMMachine.services.ATMService;

public class ATM {
	private ATMState currState;
	private Card card;
	private ATMService atmService;

	public ATM(ATMService atmService) {
		this.currState = new IdleState();
		this.atmService = atmService;
	}

	public ATMState getCurrState() {
		return currState;
	}

	public Card getCard() {
		return card;
	}

	public ATMService getAtmService() {
		return atmService;
	}

	public void setCurrState(ATMState currState) {
		this.currState = currState;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public void insertCard(Card card) {
		currState.insertCard(this, card);
	}

	public void enterPin(String pin) {
		currState.enterPin(this, pin);
	}

	public void selectTransaction(TransactionType transactionType, double amount) {
		currState.selectTransaction(this, transactionType, amount);
	}

	public void ejectCard() {
		currState.ejectCard(this);
	}
}

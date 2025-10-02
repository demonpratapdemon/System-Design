package UPIPaymentSystem.services;

import java.math.BigDecimal;

import UPIPaymentSystem.entities.User;

public class PaymentGateway {
	private final TransactionService txnService;

	public PaymentGateway(TransactionService txnService) {
		this.txnService = txnService;
	}

	public String initiatePayment(User from, User to, BigDecimal amount) {
		return txnService.createPayment(from, to, amount);
	}
}

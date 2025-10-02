package UPIPaymentSystem;

import java.math.BigDecimal;

import UPIPaymentSystem.entities.Account;
import UPIPaymentSystem.entities.Transaction;
import UPIPaymentSystem.entities.User;
import UPIPaymentSystem.services.AccountService;
import UPIPaymentSystem.services.LedgerService;
import UPIPaymentSystem.services.NotificationService;
import UPIPaymentSystem.services.PaymentGateway;
import UPIPaymentSystem.services.TransactionService;

public class DriverCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User alice = new User("Alice", "alice@gpay");
		User bob = new User("Bob", "bob@phonepe");

		AccountService accountService = new AccountService();
		accountService.addAccount(new Account(alice, new BigDecimal("2000.00")));
		accountService.addAccount(new Account(bob, new BigDecimal("1000.00")));

		LedgerService ledgerService = new LedgerService();
		TransactionService txnService = new TransactionService(accountService, ledgerService);
		PaymentGateway paymentGateway = new PaymentGateway(txnService);
		NotificationService notificationService = new NotificationService();

		String txnId = paymentGateway.initiatePayment(alice, bob, new BigDecimal("500.00"));
		Transaction txn = ledgerService.getTransaction(txnId);
		notificationService.sendNotification(txn);
	}

}

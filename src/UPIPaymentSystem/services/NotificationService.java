package UPIPaymentSystem.services;

import UPIPaymentSystem.entities.Transaction;
import UPIPaymentSystem.enums.TxnStatus;

public class NotificationService {

	public void sendNotification(Transaction txn) {
		if (txn.getStatus() == TxnStatus.SUCCESS) {
			System.out.println("Payment of " + txn.getAmount() + " successful from "
					+ txn.getFrom().getUser().getUpiId() + " to " + txn.getTo().getUser().getUpiId());
		} else {
			System.out.println("Payment failed for Txn: " + txn.getTxnId());
		}
	}
}

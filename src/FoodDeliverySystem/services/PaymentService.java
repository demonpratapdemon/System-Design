package FoodDeliverySystem.services;

import FoodDeliverySystem.entities.Payment;
import FoodDeliverySystem.enums.PaymentStatus;

public class PaymentService {

	public void processPayment(Payment payment) {
		if (payment.getAmount() > 0) {
			payment.setPaymentStatus(PaymentStatus.SUCCESS);
			System.out.println("Payment successful for ID: " + payment.getPaymentId());
		} else {
			payment.setPaymentStatus(PaymentStatus.FAILED);
			System.out.println("Payment failed for id: " + payment.getPaymentId());
		}
	}
}

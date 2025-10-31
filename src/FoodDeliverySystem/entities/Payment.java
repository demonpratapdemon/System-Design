package FoodDeliverySystem.entities;

import java.util.UUID;

import FoodDeliverySystem.enums.PaymentMethod;
import FoodDeliverySystem.enums.PaymentStatus;

public class Payment {
	private String paymentId;
	private double amount;
	private PaymentStatus paymentStatus;
	private PaymentMethod paymentMethod;

	public Payment(double amount, PaymentStatus paymentStatus, PaymentMethod paymentMethod) {
		this.paymentId = UUID.randomUUID().toString();
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public double getAmount() {
		return amount;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}

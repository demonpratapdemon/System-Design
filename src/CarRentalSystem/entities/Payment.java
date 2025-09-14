package CarRentalSystem.entities;

import java.util.Date;
import java.util.UUID;

import CarRentalSystem.enums.PaymentMode;
import CarRentalSystem.enums.PaymentStatus;

public class Payment {
	private String paymentId;
	private Reservation reservation;
	private double amount;
	private PaymentStatus paymentStatus;
	private PaymentMode paymentMode;
	private Date paymentTime;

	public Payment(Reservation reservation, double amount, PaymentMode paymentMode) {
		this.paymentId = UUID.randomUUID().toString();
		this.reservation = reservation;
		this.amount = amount;
		this.paymentMode = paymentMode;
		this.paymentTime = new Date();
		this.paymentStatus = PaymentStatus.PENDING;
	}

	public void completePayment() {
		this.paymentStatus = PaymentStatus.COMPLETED;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public double getAmount() {
		return amount;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", reservation=" + reservation + ", amount=" + amount
				+ ", paymentStatus=" + paymentStatus + ", paymentMode=" + paymentMode + ", paymentTime=" + paymentTime
				+ "]";
	}

	
}

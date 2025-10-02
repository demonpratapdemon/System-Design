package UPIPaymentSystem.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import UPIPaymentSystem.enums.TxnStatus;

public class Transaction {
	private String txnId;
	private Account from;
	private Account to;
	private BigDecimal amount;
	private TxnStatus status;
	private LocalDate createdAt;

	public Transaction(Account from, Account to, BigDecimal amount) {
		this.txnId = UUID.randomUUID().toString();
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.status = TxnStatus.INITIATED;
		this.createdAt = LocalDate.now();
	}

	public Account getFrom() {
		return from;
	}

	public void setFrom(Account from) {
		this.from = from;
	}

	public Account getTo() {
		return to;
	}

	public void setTo(Account to) {
		this.to = to;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public TxnStatus getStatus() {
		return status;
	}

	public void setStatus(TxnStatus status) {
		this.status = status;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public String getTxnId() {
		return this.txnId;
	}

}

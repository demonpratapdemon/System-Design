package UPIPaymentSystem.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import UPIPaymentSystem.entities.Transaction;

public class LedgerService {
	private final Map<String, Transaction> ledger;

	public LedgerService() {
		this.ledger = new ConcurrentHashMap<String, Transaction>();
	}

	public void save(Transaction txn) {
		// TODO Auto-generated method stub
		ledger.put(txn.getTxnId(), txn);
	}

	public void update(Transaction txn) {
		// TODO Auto-generated method stub
		ledger.put(txn.getTxnId(), txn);
	}

	public Transaction getTransaction(String txnId) {
		return ledger.get(txnId);
	}

}

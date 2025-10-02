package UPIPaymentSystem.services;

import java.math.BigDecimal;

import UPIPaymentSystem.entities.Account;
import UPIPaymentSystem.entities.Transaction;
import UPIPaymentSystem.entities.User;
import UPIPaymentSystem.enums.TxnStatus;

public class TransactionService {
	private final AccountService accountService;
	private final LedgerService ledgerService;

	public TransactionService(AccountService accountService, LedgerService ledgerService) {
		this.accountService = accountService;
		this.ledgerService = ledgerService;
	}

	public String createPayment(User from, User to, BigDecimal amount) {
		// TODO Auto-generated method stub
		Account fromAccount = accountService.getAccount(from);
		Account toAccount = accountService.getAccount(to);

		Transaction txn = new Transaction(fromAccount, toAccount, amount);
		ledgerService.save(txn);

		boolean success = accountService.transferAmount(fromAccount, toAccount, amount, txn.getTxnId());
		if (success)
			txn.setStatus(TxnStatus.SUCCESS);
		else
			txn.setStatus(TxnStatus.FAILED);

		ledgerService.update(txn);
		return txn.getTxnId();
	}

}

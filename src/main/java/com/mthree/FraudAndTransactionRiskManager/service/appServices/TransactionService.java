package com.mthree.FraudAndTransactionRiskManager.service.appServices;

//unfinished
import com.mthree.FraudAndTransactionRiskManager.dto.RiskFlag;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import com.mthree.FraudAndTransactionRiskManager.dto.wrappers.TransactionWrapper;

import java.util.List;

public interface TransactionService {

    public void updateTransactions();

    public List<Transaction> getTransactions();

    public Transaction getTransaction(String transactionID);

    public List<Transaction> getTransactionsForAccount(String accountID);
}

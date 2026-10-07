package com.mthree.FraudAndTransactionRiskManager.service.appServices;

//unfinished
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

public interface TransactionService {

    public void updateTransactions();

    public List<Transaction> getTransactions();

    public Transaction getTransaction(String transactionID);

    public List<Transaction> getTransactionsForAccount(String accountID);

    Map<String,List<Transaction>> getTransactionForWeek();

    List<Transaction> getTransactionForDay();
}

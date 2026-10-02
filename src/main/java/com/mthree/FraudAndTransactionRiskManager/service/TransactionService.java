package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;

import java.util.List;

public interface TransactionService {

    public void updateTransactions();

    public List<Transaction> getTransactions();

    public Transaction getTransaction(int transactionID);

    public List<Transaction> searchTransactions(String searchString);

}

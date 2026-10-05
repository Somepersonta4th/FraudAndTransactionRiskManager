package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface TransactionDao {
    public ArrayList<Transaction> getTransactions();

    void updateTransactions();

    Transaction findTransactionById(String transactionId);

    List<Transaction> findTransactionsByAccountId(String accountId);
}

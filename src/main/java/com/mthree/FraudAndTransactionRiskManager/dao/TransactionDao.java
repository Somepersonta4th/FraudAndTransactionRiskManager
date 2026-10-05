package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface TransactionDao {
    public ArrayList<Transaction> getTransactions();

    Transaction findTransactionById(int transactionId);

    List<Transaction> findTransactionsByAccountId(int accountId);
}

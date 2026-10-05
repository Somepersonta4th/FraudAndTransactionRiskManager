package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;

import java.util.ArrayList;

public interface TransactionDao {
    public ArrayList<Transaction> getTransactions();
}

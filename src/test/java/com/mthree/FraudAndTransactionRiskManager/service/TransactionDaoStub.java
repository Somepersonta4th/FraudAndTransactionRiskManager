package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dao.TransactionDao;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionDaoStub implements TransactionDao {

    private ArrayList<Transaction> transactions = new ArrayList<>();

    public TransactionDaoStub() {
        Transaction newTransaction = new Transaction();
        newTransaction.setAccountId("1");
        newTransaction.setDescription("abcdef");
        transactions.add(newTransaction);

        newTransaction = new Transaction();
        newTransaction.setAccountId("2");
        newTransaction.setDescription("abcdef");
        transactions.add(newTransaction);

        newTransaction = new Transaction();
        newTransaction.setAccountId("3");
        newTransaction.setDescription("fghijkl");
        transactions.add(newTransaction);
    }
    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void updateTransactions() {

    }

    @Override
    public Transaction findCaseById(String transactionID) {
        return transactions.get(0);
    }
}

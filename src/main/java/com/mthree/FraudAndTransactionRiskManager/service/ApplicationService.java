package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mthree.FraudAndTransactionRiskManager.dto.RiskRule;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import com.mthree.FraudAndTransactionRiskManager.dto.wrappers.TransactionWrapper;

import java.util.List;

public interface ApplicationService {
    public List<Transaction> getTransactions();

    public Transaction getTransaction(String transactionID);

    public TransactionWrapper getTransactionInfo(String transactionID);

    public List<Transaction> searchTransactions(String searchString);

    public List<Account> getAccounts();

    public Account getAccount(String accountID);

    public List<Account> searchAccounts(String searchString);

    public List<Transaction> getTransactionsForAccount(String accountID);

    public List<RiskRule> getRiskRules();

    public RiskRule getRiskRule(String ruleCode);
}

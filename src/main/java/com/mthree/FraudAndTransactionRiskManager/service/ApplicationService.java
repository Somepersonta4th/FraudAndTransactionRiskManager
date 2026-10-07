package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dto.*;
import com.mthree.FraudAndTransactionRiskManager.dto.wrappers.TransactionWrapper;

import java.util.List;

public interface ApplicationService {
    public List<Transaction> getTransactions();

    public Transaction getTransaction(String transactionID);

    public List<Transaction> searchTransactions(String searchString);

    public List<Account> getAccounts();

    public Account getAccount(String accountID);

    public List<Account> searchAccounts(String searchString);

    public List<Transaction> getTransactionsForAccount(String accountID);

    /*
    public List<RiskRule> getRiskRules();

    public RiskRule getRiskRule(String ruleCode);

    public List<RiskFlag> getTransactionFlags(String transactionID);
     */

    public Case getCase(int caseID);

    public Case setCaseScore(int caseID, int score, String priority);

    public Case addCaseForAccount(String accountID);

    public List<Case> getCasesForAccount(String accountID);
}

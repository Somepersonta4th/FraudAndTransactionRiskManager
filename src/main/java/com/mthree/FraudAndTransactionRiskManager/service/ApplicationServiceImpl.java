package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mthree.FraudAndTransactionRiskManager.dto.RiskRule;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import com.mthree.FraudAndTransactionRiskManager.dto.wrappers.TransactionWrapper;
import com.mthree.FraudAndTransactionRiskManager.service.appServices.AccountService;
import com.mthree.FraudAndTransactionRiskManager.service.appServices.RiskService;
import com.mthree.FraudAndTransactionRiskManager.service.appServices.SearchService;
import com.mthree.FraudAndTransactionRiskManager.service.appServices.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountService accountService;

    @Autowired
    RiskService riskService;

    @Autowired
    SearchService searchService;

    @Override
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }

    @Override
    public Transaction getTransaction(String transactionID) {
        return transactionService.getTransaction(transactionID);
    }

    @Override
    public TransactionWrapper getTransactionInfo(String transactionID) {
        return transactionService.getTransactionInfo(transactionID);
    }

    @Override
    public List<Transaction> searchTransactions(String searchString) {
        return transactionService.searchTransactions(searchString);
    }

    @Override
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @Override
    public Account getAccount(String accountID) {
        return accountService.getAccount(accountID);
    }

    @Override
    public List<Account> searchAccounts(String searchString) {
        return accountService.searchAccounts(searchString);
    }

    @Override
    public List<Transaction> getTransactionsForAccount(String accountID) {
        if (accountService.getAccount(accountID) == null) {
            return null;
        }
        return transactionService.getTransactionsForAccount(accountID);
    }

    @Override
    public List<RiskRule> getRiskRules() {
        return riskService.getRiskRules();
    }

    @Override
    public RiskRule getRiskRule(String ruleCode) {
        return riskService.getRiskRule(ruleCode);
    }
}

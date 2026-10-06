package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dto.*;
import com.mthree.FraudAndTransactionRiskManager.dto.wrappers.TransactionWrapper;
import com.mthree.FraudAndTransactionRiskManager.service.appServices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountService accountService;

    @Autowired
    RiskService riskService;

    @Autowired
    CaseService caseService;

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

    @Override
    public List<RiskFlag> getTransactionFlags(String transactionID) {
        if (transactionService.getTransaction(transactionID) == null) {
            return null;
        }
        return riskService.getRiskFlagForTransaction(transactionID);
    }

    @Override
    public Case getCase(int caseID) {
        return caseService.getCase(caseID);
    }

    @Override
    public Case setCaseScore(int caseID, int score, String priority) {
        return caseService.setCaseScore(caseID,score,priority);
    }
}

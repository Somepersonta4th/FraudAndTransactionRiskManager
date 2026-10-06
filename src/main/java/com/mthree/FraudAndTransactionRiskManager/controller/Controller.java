package com.mthree.FraudAndTransactionRiskManager.controller;

import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mthree.FraudAndTransactionRiskManager.dto.RiskRule;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import com.mthree.FraudAndTransactionRiskManager.dto.wrappers.TransactionWrapper;
import com.mthree.FraudAndTransactionRiskManager.service.ApplicationService;
import com.mthree.FraudAndTransactionRiskManager.service.appServices.AccountService;
import com.mthree.FraudAndTransactionRiskManager.service.AuditService;
import com.mthree.FraudAndTransactionRiskManager.service.appServices.RiskService;
import com.mthree.FraudAndTransactionRiskManager.service.appServices.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/FTRM")
//unfinished
public class Controller {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    AuditService auditService;

    // retrieve all transactions
    @GetMapping("/transactions/all")
    public List<Transaction> getAllTransaction() {
        auditService.writeToAudit("getAllTransaction");
        return applicationService.getTransactions();
    }

    // retrieve transaction with id
    @GetMapping("/transactions/id/{accountID}")
    public Transaction getTransaction(@PathVariable String transactionID) {
        auditService.writeToAudit("getTransaction:" + transactionID);
        return applicationService.getTransaction(transactionID);
    }

    // retrieve transaction and related data with id
    @GetMapping("/transactions/info/{accountID}")
    public TransactionWrapper getTransactionInfo(@PathVariable String transactionID) {
        auditService.writeToAudit("getTransactionInfo:" + transactionID);
        return applicationService.getTransactionInfo(transactionID);
        
    }

    // retrieve transactions with search
    @GetMapping("/transactions/search")
    public List<Transaction> searchTransactions(String searchString) {
        auditService.writeToAudit("searchTransactions:" + searchString);
        return applicationService.searchTransactions(searchString);
    }

    // retrieve all account
    @GetMapping("/cases/all")
    public List<Account> getAllTransactions() {
        auditService.writeToAudit("getAllTransactions");
        return applicationService.getAccounts();
    }

    // retrieve account with id
    @GetMapping("/accounts/id/{accountID}")
    public Account getAccount(@PathVariable String accountID) {
        auditService.writeToAudit("getAccount:" + accountID);
        return applicationService.getAccount(accountID);
    }

    // retrieve accounts with search
    @GetMapping("/accounts/search")
    public List<Account> searchAccounts(String searchString) {
        auditService.writeToAudit("searchAccounts:" + searchString);
        return applicationService.searchAccounts(searchString);
    }

    // retrieve transactions relating to account
    @GetMapping("/accounts/transactions-for-id/{accountID}")
    public List<Transaction> getAccountTransactions(@PathVariable String accountID) {
        auditService.writeToAudit("getAccountTransactions:" + accountID);
        return applicationService.getTransactionsForAccount(accountID);
    }

    // retrieve all risk rules
    @GetMapping("/risk-rules/all")
    public List<RiskRule> getRiskRules() {
        auditService.writeToAudit("getRiskRules");
        return applicationService.getRiskRules();
    }

    // retrieve risk rules by ID
    @GetMapping("/risk-rules/{ruleCode}")
    public RiskRule getRiskRule(@PathVariable String ruleCode) {
        auditService.writeToAudit("getRiskRule:" + ruleCode);
        return applicationService.getRiskRule(ruleCode);
    }

    @GetMapping("/{testString}")
    public String test(@PathVariable String testString) {
        return testString + "test";
    }
}

package com.mthree.FraudAndTransactionRiskManager.controller;

import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import com.mthree.FraudAndTransactionRiskManager.dto.wrappers.TransactionWrapper;
import com.mthree.FraudAndTransactionRiskManager.service.AccountService;
import com.mthree.FraudAndTransactionRiskManager.service.AuditService;
import com.mthree.FraudAndTransactionRiskManager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/FTRM")
//unfinished
public class Controller {

    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountService accountService;

    @Autowired
    AuditService auditService;

    @GetMapping("/transactions/all")
    public List<Transaction> getAllTransaction() {
        auditService.writeToAudit("getAllTransaction");
        return transactionService.getTransactions();
    }

    @GetMapping("/transactions/id/{accountID}")
    public Transaction getTransaction(@PathVariable String transactionID) {
        auditService.writeToAudit("getTransaction:" + transactionID);
        return transactionService.getTransaction(transactionID);
    }

    @GetMapping("/transactions/info/{accountID}")
    public TransactionWrapper getTransactionInfo(@PathVariable String transactionID) {
        auditService.writeToAudit("getTransactionInfo:" + transactionID);
        return transactionService.getTransactionInfo(transactionID);
        
    }

    @GetMapping("/transactions/search")
    public List<Transaction> searchTransactions(String searchString) {
        auditService.writeToAudit("searchTransactions:" + searchString);
        return transactionService.searchTransactions(searchString);
    }

    @GetMapping("/accounts/id/{accountID}")
    public Account getAccount(@PathVariable String accountID) {
        auditService.writeToAudit("getAccount:" + accountID);
        return accountService.getAccount(accountID);
    }

    @GetMapping("/cases/all")
    public List<Account> getAllTransactions() {
        auditService.writeToAudit("getAllTransactions");
        return accountService.getAccounts();
    }

    @GetMapping("/accounts/search")
    public List<Account> searchAccounts(String searchString) {
        auditService.writeToAudit("searchAccounts:" + searchString);
        return accountService.searchAccounts(searchString);
    }

    @GetMapping("/accounts/transactions-for-id/{accountID}")
    public List<Transaction> getAccountTransactions(@PathVariable String accountID) {
        auditService.writeToAudit("getAccountTransactions:" + accountID);
        return accountService.getTransactionsForAccount(accountID);
    }

    @GetMapping("/{testString}")
    public String test(@PathVariable String testString) {
        return testString + "test";
    }
}

package com.mthree.FraudAndTransactionRiskManager.controller;

import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import com.mthree.FraudAndTransactionRiskManager.service.AccountService;
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

    @GetMapping("/transactions/search")
    public List<Transaction> searchTransactions(String searchString) {
        return transactionService.searchTransactions(searchString);
    }

    @GetMapping("/accounts/search")
    public List<Account> searchAccounts(String searchString) {
        return accountService.searchAccounts(searchString);
    }

    @GetMapping("/{testString}")
    public String test(@PathVariable String testString) {
        return testString + "test";
    }
}

package com.mthree.FraudAndTransactionRiskManager.controller;

import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
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

    @GetMapping("/transactions/search")
    public List<Transaction> searchTransactions(String searchString) {
        return transactionService.searchTransactions(searchString);
    }

    @GetMapping("/{testString}")
    public String test(@PathVariable String testString) {
        return testString + "test";
    }
}

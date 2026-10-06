package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import com.mthree.FraudAndTransactionRiskManager.service.appServices.SearchServiceImpl;
import com.mthree.FraudAndTransactionRiskManager.service.appServices.TransactionService;
import com.mthree.FraudAndTransactionRiskManager.service.appServices.TransactionServiceImpl;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TransactionServiceImplTest extends TestCase {

    private TransactionService transactionService = new TransactionServiceImpl(new TransactionDaoStub(), new SearchServiceImpl());

    @Test
    void searchTransaction() {

        List<Transaction> results = transactionService.searchTransactions("abc");

        Assertions.assertEquals(2,results.size(),"Should return 2 results");
    }

    @Test
    void fuzzySearchTransaction() {

        List<Transaction> results = transactionService.searchTransactions("*acbd");

        Assertions.assertEquals(2,results.size(),"Should return 2 results");
    }

    @Test
    void fieldSearchTransaction() {

        List<Transaction> results = transactionService.searchTransactions("description:abc");

        Assertions.assertEquals(2,results.size(),"Should return 2 results");
    }

    @Test
    void getTransactionByID() {
        Transaction result = transactionService.getTransaction("1");

        Assertions.assertEquals("abcdef",result.getDescription());
    }

}
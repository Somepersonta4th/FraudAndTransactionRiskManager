package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dao.TransactionDao;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

}
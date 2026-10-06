package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import com.mthree.FraudAndTransactionRiskManager.service.appServices.*;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ApplicationServiceImplTest extends TestCase {

    private ApplicationService applicationService = new ApplicationServiceImpl(new TransactionServiceImpl(new TransactionDaoStub()),new AccountServiceImpl(new AccountDaoStub()), new RiskServiceImpl(), new CaseServiceImpl(), new SearchServiceImpl());

    @Test
    void searchTransaction() {

        List<Transaction> results = applicationService.searchTransactions("abc");

        Assertions.assertEquals(2,results.size(),"Should return 2 results");
    }

    @Test
    void fuzzySearchTransaction() {

        List<Transaction> results = applicationService.searchTransactions("*acbd");

        Assertions.assertEquals(2,results.size(),"Should return 2 results");
    }

    @Test
    void fieldSearchTransaction() {

        List<Transaction> results = applicationService.searchTransactions("description:abc");

        Assertions.assertEquals(2,results.size(),"Should return 2 results");
    }

    @Test
    void getTransactionByID() {
        Transaction result = applicationService.getTransaction("1");

        Assertions.assertEquals("abcdef",result.getDescription());
    }

    @Test
    void searchAccount() {

        List<Account> results = applicationService.searchAccounts("abc");

        Assertions.assertEquals(2,results.size(),"Should return 2 results");
    }

    @Test
    void fuzzySearchAccount() {

        List<Account> results = applicationService.searchAccounts("*acbd");

        Assertions.assertEquals(2,results.size(),"Should return 2 results");
    }

    @Test
    void fieldSearchAccount() {

        List<Account> results = applicationService.searchAccounts("name:abc");

        Assertions.assertEquals(2,results.size(),"Should return 2 results");
    }

}
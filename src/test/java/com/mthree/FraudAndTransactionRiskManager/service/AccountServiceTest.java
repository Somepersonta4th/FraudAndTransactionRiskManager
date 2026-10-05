package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AccountServiceTest extends TestCase {

    private AccountService accountService = new AccountServiceImpl(new AccountDaoStub(), new TransactionServiceImpl(new TransactionDaoStub(), new SearchServiceImpl()),new SearchServiceImpl());

    @Test
    void searchAccount() {

        List<Account> results = accountService.searchAccounts("abc");

        Assertions.assertEquals(2,results.size(),"Should return 2 results");
    }

    @Test
    void fuzzySearchAccount() {

        List<Account> results = accountService.searchAccounts("*acbd");

        Assertions.assertEquals(2,results.size(),"Should return 2 results");
    }

    @Test
    void fieldSearchAccount() {

        List<Account> results = accountService.searchAccounts("name:abc");

        Assertions.assertEquals(2,results.size(),"Should return 2 results");
    }

}
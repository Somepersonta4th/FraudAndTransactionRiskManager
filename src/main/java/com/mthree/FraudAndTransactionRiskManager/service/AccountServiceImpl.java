package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dao.AccountDao;
import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    @Autowired
    TransactionService transactionService;

    @Autowired
    SearchService searchService;

    public AccountServiceImpl(AccountDao accountDao, TransactionService transactionService, SearchService searchService) {
        this.accountDao = accountDao;
        this.transactionService = transactionService;
        this.searchService = searchService;
    }

    @Override
    public void updateAccounts() {
        accountDao.updateAccounts();
    }

    @Override
    public List<Account> getAccounts() {
        return accountDao.getAccounts();
    }

    @Override
    public List<Account> searchAccounts(String searchString) {
        return searchAccounts(searchString,getAccounts());
    }

    @Override
    public List<Account> searchAccounts(String searchString, List<Account> accounts) {
        return (List<Account>) searchService.searchObjectsBy(searchString,accounts);
    }

    @Override
    public Account getAccount(String accountID) {
        return accountDao.findAccountById(accountID);
    }

    @Override
    public List<Transaction> getTransactionsForAccount(String accountID) {
        if (accountDao.findAccountById(accountID) == null) {
            return null;
        }

        return transactionService.getTransactionsForAccount(accountID);
    }
}

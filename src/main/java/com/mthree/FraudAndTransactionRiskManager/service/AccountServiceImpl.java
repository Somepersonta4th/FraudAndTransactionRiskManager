package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dao.AccountDao;
import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Account> getAccounts() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Account> searchAccounts(String searchString) {
        return searchAccounts(searchString,accountDao.getAccounts());
    }

    @Override
    public List<Account> searchAccounts(String searchString, List<Account> accounts) {
        return (List<Account>) searchService.searchObjectsBy(searchString,accounts);
    }

    @Override
    public Account getAccount(int accountID) {
        throw new UnsupportedOperationException();
    }
}

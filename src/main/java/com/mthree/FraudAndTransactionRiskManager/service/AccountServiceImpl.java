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
        return accountDao.getAccount(accountID);
    }

    @Override
    public List<Transaction> getTransactionsForAccount(String accountID) {
        if (accountDao.getAccount(accountID) == null) {
            return null;
        }

        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : transactionService.getTransactions()) {
            if (transaction.getAccountId().equals(accountID)) {
                transactions.add(transaction);
            }
        }
        return List.of();
    }
}

package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dao.AccountDao;
import com.mthree.FraudAndTransactionRiskManager.dto.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDaoStub implements AccountDao {

    private ArrayList<Account> accounts = new ArrayList<>();

    public AccountDaoStub() {
        Account newAccount1 = new Account();
        newAccount1.setId("1");
        newAccount1.setName("abcdef");
        accounts.add(newAccount1);

        Account newAccount2 = new Account();
        newAccount2.setId("2");
        newAccount2.setName("abcdef");
        accounts.add(newAccount2);

        Account newAccount3 = new Account();
        newAccount3.setId("3");
        newAccount3.setName("fghijkl");
        accounts.add(newAccount3);
    }

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }
}

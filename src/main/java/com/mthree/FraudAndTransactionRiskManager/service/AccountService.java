package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dto.BankAccount;

import java.util.List;

public interface AccountService {

    public void updateAccounts();

    public List<BankAccount> getAccounts();

    public List<BankAccount> searchAccounts(String searchString);

    public BankAccount getAccount(int accountID);

}

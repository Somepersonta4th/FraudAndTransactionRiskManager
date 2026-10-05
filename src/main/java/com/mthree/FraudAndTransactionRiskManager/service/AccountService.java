package com.mthree.FraudAndTransactionRiskManager.service;

//unfinished
import com.mthree.FraudAndTransactionRiskManager.dto.Account;

import java.util.List;

public interface AccountService {

    public void updateAccounts();

    public List<Account> getAccounts();

    public List<Account> searchAccounts(String searchString);

    public List<Account> searchAccounts(String searchString, List<Account> accounts);

    public Account getAccount(int accountID);

}

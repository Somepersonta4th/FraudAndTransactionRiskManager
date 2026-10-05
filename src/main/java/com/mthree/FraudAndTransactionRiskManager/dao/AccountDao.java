package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.dto.Account;

import java.util.ArrayList;
import java.util.List;

public interface AccountDao {
    ArrayList<Account> getAccounts();

    Account findAccountById(int accountId);

    List<Account> getAllAccounts();
}

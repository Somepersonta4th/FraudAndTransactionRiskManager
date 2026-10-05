package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.dto.Account;

import java.util.ArrayList;
import java.util.List;

public interface AccountDao {

    Account findAccountById(String accountId);

    List<Account> getAccounts();

    void updateAccounts();
}

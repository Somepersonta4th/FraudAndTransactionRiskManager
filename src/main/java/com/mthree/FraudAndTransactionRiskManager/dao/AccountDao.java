package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.dto.Account;

import java.util.ArrayList;

public interface AccountDao {
    ArrayList<Account> getAccounts();
}

package com.mthree.FraudAndTransactionRiskManager.service.appServices;

//unfinished
import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;

import java.util.List;

public interface AccountService {

    public void updateAccounts();

    public List<Account> getAccounts();

    public Account getAccount(String accountID);
}

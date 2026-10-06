package com.mthree.FraudAndTransactionRiskManager.dto.wrappers;

import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mthree.FraudAndTransactionRiskManager.dto.Case;

import java.util.List;

public class CaseWrapper {
    private Case aCase;

    private Account account;

    private List<TransactionWrapper> transactions;


}

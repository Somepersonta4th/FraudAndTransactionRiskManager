package com.mthree.FraudAndTransactionRiskManager.dto.wrappers;

import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mthree.FraudAndTransactionRiskManager.dto.RiskFlag;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;

import java.util.List;

public class TransactionWrapper {
    private Transaction transaction;

    private List<RiskFlag> riskFlags;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public List<RiskFlag> getRiskFlags() {
        return riskFlags;
    }

    public void setRiskFlags(List<RiskFlag> riskFlags) {
        this.riskFlags = riskFlags;
    }
}

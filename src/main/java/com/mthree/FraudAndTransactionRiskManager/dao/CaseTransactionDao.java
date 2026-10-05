package com.mthree.FraudAndTransactionRiskManager.dao;

import java.util.List;

public interface CaseTransactionDao {

    void addTransactionToCase(int caseId, int transactionId, String role);

    boolean isTransactionInCase(int caseId, int transactionId);

    List<CaseTransactionDao> findTransactionsByCaseId(int caseId);
}

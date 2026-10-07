package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.dto.Case;

import java.util.List;

public interface CaseDao {

    //Saves a new case and returns with caseId
    Case createCase(Case fraudCase);

    //The case with its transactions
    Case findCaseById(int caseId);

    // The account's cases that are still open
    List<Case> findOpenCaseByAccountId(String accountId);

    void updateCaseScore(int caseId, int score);

    // Every case, each with its transactions.
    List<Case> findAllCases();

    // Saves changes to a case's description, status and closedAt.
    void updateCase(Case updatedCase);

    // Deletes the case row.
    void deleteCase(int caseId);

    // Links one transaction to a case (one row in the case_transaction table).
    void addTransactionToCase(int caseId, String transactionId);

    // The ids of every transaction linked to a case.
    List<String> findTransactionIdsByCaseId(int caseId);

    // Deletes all of a case's transaction links.
    void deleteTransactionsFromCase(int caseId);
}
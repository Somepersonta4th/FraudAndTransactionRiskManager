package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.dto.Case;

import java.util.List;
import java.util.Optional;

public interface CaseDao {

    Case createCase(Case fraudCase);

    Case findCaseById(int caseId);

    /** The account's case that is still open, under investigation or escalated, if any. */
    List<Case> findOpenCaseByAccountId(int accountId);

    void updateCaseScore(int caseId, int score);
}

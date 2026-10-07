package com.mthree.FraudAndTransactionRiskManager.service.appServices;

//unfinished
import com.mthree.FraudAndTransactionRiskManager.dto.Auditor;
import com.mthree.FraudAndTransactionRiskManager.dto.Case;
import com.mthree.FraudAndTransactionRiskManager.dto.CaseNote;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;

import java.util.List;

public interface CaseService {
    Case getCase(int caseID);

    Case setCaseScore(int caseID, int score, String priority);

    Case addCaseForAccount(String accountID);

    List<Case> getCasesForAccount(String accountID);

    // Saves a new case and links its transactions; returns the case with its new caseId
    Case createCase(Case newCase);

    // Returns every case
    List<Case> getCases();

    // Saves changes to an existing case (description, status, closedAt) returns the updated case
    Case updateCase(Case updatedCase);

    // Deletes a case and its links
    void deleteCase(int caseID);
}

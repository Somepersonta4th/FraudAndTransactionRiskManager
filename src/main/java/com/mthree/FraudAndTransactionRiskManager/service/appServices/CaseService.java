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
}

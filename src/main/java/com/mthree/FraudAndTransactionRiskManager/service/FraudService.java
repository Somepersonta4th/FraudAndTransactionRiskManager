package com.mthree.FraudAndTransactionRiskManager.service;

//unfinished
import com.mthree.FraudAndTransactionRiskManager.dto.Auditor;
import com.mthree.FraudAndTransactionRiskManager.dto.Case;
import com.mthree.FraudAndTransactionRiskManager.dto.CaseNote;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;

import java.util.List;

public interface FraudService {

    public List<Case> getCases();

    public List<Auditor> getAuditors();

    public List<CaseNote> getCaseNotes(Case aCase);

    public List<Transaction> getCaseTransactions(Case aCase);


}

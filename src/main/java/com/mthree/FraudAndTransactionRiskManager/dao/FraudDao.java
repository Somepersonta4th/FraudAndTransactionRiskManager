package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.dto.Auditor;
import com.mthree.FraudAndTransactionRiskManager.dto.Case;
import com.mthree.FraudAndTransactionRiskManager.dto.CaseNote;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//unfinished
public interface FraudDao {

    public List<Case> getCases();

    public Case getCase(int caseID);

}

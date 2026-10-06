package com.mthree.FraudAndTransactionRiskManager.service.appServices;

import com.mthree.FraudAndTransactionRiskManager.dao.CaseDao;
import com.mthree.FraudAndTransactionRiskManager.dto.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    CaseDao caseDao;

    @Override
    public Case getCase(int caseID) {
        return caseDao.findCaseById(caseID);
    }

    @Override
    public Case setCaseScore(int caseID, int score, String priority) {
        if (caseDao.findCaseById(caseID) == null) {
            return null;
        }
        caseDao.updateCaseScore(caseID, score);
        return caseDao.findCaseById(caseID);
    }
}

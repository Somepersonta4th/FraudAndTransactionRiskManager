package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dao.RiskFlagDao;
import com.mthree.FraudAndTransactionRiskManager.dto.RiskFlag;
import com.mthree.FraudAndTransactionRiskManager.dto.RiskRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RiskServiceImpl implements RiskService {

    @Autowired
    RiskFlagDao riskFlagDao;

    @Override
    public List<RiskRule> getRisks() {
        return List.of();
    }

    @Override
    public RiskRule getRisk(int riskID) {
        return null;
    }

    @Override
    public List<RiskFlag> getRiskFlagForTransaction(String transactionID) {
        return riskFlagDao.findFlagsByTransactionId(transactionID);
    }

    @Override
    public List<RiskFlag> getRiskFlagForAccount(String accountID) {
        return riskFlagDao.findFlagsByAccountId(accountID);
    }
}

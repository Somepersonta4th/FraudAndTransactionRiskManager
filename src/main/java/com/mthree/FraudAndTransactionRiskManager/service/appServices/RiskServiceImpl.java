package com.mthree.FraudAndTransactionRiskManager.service.appServices;

import com.mthree.FraudAndTransactionRiskManager.dao.RiskFlagDao;
import com.mthree.FraudAndTransactionRiskManager.dao.RiskRuleDao;
import com.mthree.FraudAndTransactionRiskManager.dto.RiskFlag;
import com.mthree.FraudAndTransactionRiskManager.dto.RiskRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RiskServiceImpl implements RiskService {

    @Autowired
    RiskFlagDao riskFlagDao;

    @Autowired
    RiskRuleDao riskRuleDao;

    @Override
    public List<RiskRule> getRiskRules() {
        return riskRuleDao.getAllRules();
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

    @Override
    public RiskRule getRiskRule(String ruleCode) {
        return riskRuleDao.findRuleByCode(ruleCode);
    }
}

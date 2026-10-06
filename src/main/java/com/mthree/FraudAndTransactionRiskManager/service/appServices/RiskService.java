package com.mthree.FraudAndTransactionRiskManager.service.appServices;

import com.mthree.FraudAndTransactionRiskManager.dto.RiskFlag;
import com.mthree.FraudAndTransactionRiskManager.dto.RiskRule;

import java.util.List;

//unfinished
public interface RiskService {

    public List<RiskRule> getRiskRules();

    public RiskRule getRisk(int riskID);

    public List<RiskFlag> getRiskFlagForTransaction(String transactionID);

    public List<RiskFlag> getRiskFlagForAccount(String accountID);

    public RiskRule getRiskRule(String ruleCode);
}

package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dto.RiskRule;

import java.util.List;

//unfinished
public interface RiskService {

    public List<RiskRule> getRisks();

    public RiskRule getRisk(int riskID);

}

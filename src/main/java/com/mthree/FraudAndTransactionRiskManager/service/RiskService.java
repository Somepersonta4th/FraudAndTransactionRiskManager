package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dto.Risk;

import java.util.List;

//unfinished
public interface RiskService {

    public List<Risk> getRisks();

    public Risk getRisk(int riskID);

}

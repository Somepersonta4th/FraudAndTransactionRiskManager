package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dao.RiskFlagDao;
import com.mthree.FraudAndTransactionRiskManager.dto.RiskFlag;
import com.mthree.FraudAndTransactionRiskManager.dto.RiskRule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//unfinished
public interface RiskService {

    public List<RiskRule> getRisks();

    public RiskRule getRisk(int riskID);

    public List<RiskFlag> getRiskFlagForTransaction(String transactionID);

    public List<RiskFlag> getRiskFlagForAccount(String accountID);

}

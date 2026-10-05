package com.mthree.FraudAndTransactionRiskManager.dao;


import com.mthree.FraudAndTransactionRiskManager.dto.RiskFlag;

import java.util.List;

public interface RiskFlagDao {

    RiskFlag createFlag(RiskFlag flag);

    boolean flagExists(String transactionId, int ruleId);

    List<RiskFlag> findFlagsByAccountId(String accountId);

    List<RiskFlag> findFlagsByTransactionId(String transactionId);
}

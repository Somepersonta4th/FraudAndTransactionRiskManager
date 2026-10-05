package com.mthree.FraudAndTransactionRiskManager.dao;


import com.mthree.FraudAndTransactionRiskManager.dto.RiskFlag;

import java.util.List;

public interface RiskFlagDao {

    RiskFlag createFlag(RiskFlag flag);

    boolean flagExists(int transactionId, int ruleId);

    List<RiskFlag> findFlagsByAccountId(int accountId);

    List<RiskFlag> findFlagsByTransactionId(int transactionId);
}

package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.dto.RiskRule;

import java.util.List;

public interface RiskRuleDao {

    List<RiskRule> getAllRules();

    RiskRule findRuleByCode(String ruleCode);
}

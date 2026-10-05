package com.mthree.FraudAndTransactionRiskManager.dto;

import java.math.BigDecimal;

public class RiskRule {

    private int ruleId;
    private String ruleCode;
    private String description;
    private int points;
    private BigDecimal threshold;
    private boolean enabled;

    public int getRuleId() { return ruleId; }
    public void setRuleId(int ruleId) { this.ruleId = ruleId; }

    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public BigDecimal getThreshold() { return threshold; }
    public void setThreshold(BigDecimal threshold) { this.threshold = threshold; }

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}

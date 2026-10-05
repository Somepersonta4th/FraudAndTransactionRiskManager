package com.mthree.FraudAndTransactionRiskManager.dto;

//unfinished
public class RiskFlag {

    private int flagId;
    private int transactionId;
    private int ruleId;
    private String ruleCode;
    private int pointsAwarded;
    private String reason;

    public RiskFlag() {
    }

    public RiskFlag(int transactionId, int ruleId, int pointsAwarded, String reason) {
        this.transactionId = transactionId;
        this.ruleId = ruleId;
        this.pointsAwarded = pointsAwarded;
        this.reason = reason;
    }

    public int getFlagId() { return flagId; }
    public void setFlagId(int flagId) { this.flagId = flagId; }

    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }

    public int getRuleId() { return ruleId; }
    public void setRuleId(int ruleId) { this.ruleId = ruleId; }

    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }

    public int getPointsAwarded() { return pointsAwarded; }
    public void setPointsAwarded(int pointsAwarded) { this.pointsAwarded = pointsAwarded; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}

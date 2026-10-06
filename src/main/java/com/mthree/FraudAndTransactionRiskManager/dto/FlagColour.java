package com.mthree.FraudAndTransactionRiskManager.dto;

public enum FlagColour {
    GREEN,
    AMBER,
    RED;

    // Turns the number of fraud rules to a transaction colour
    public static FlagColour fromRuleCount(int rulesFired) {
        if (rulesFired == 0) {
            return GREEN;
        }
        if (rulesFired == 1) {
            return AMBER;
        }
        return RED;
    }
}

package com.mthree.FraudAndTransactionRiskManager.dto;

public enum CaseStatus {
    // Case lifecycle statuses
    OPEN,
    UNDER_INVESTIGATION,
    ESCALATED,
    CLOSED_SAFE,
    CLOSED_FRAUD;

    public static CaseStatus getStatusFromString(String status) {
        return switch (status) {
            case "OPEN" -> OPEN;
            case "UNDER_INVESTIGATION" -> UNDER_INVESTIGATION;
            case "ESCALATED" -> ESCALATED;
            case "CLOSED_SAFE" -> CLOSED_SAFE;
            case "CLOSED_FRAUD" -> CLOSED_FRAUD;
            default -> null;
        };
    }
}

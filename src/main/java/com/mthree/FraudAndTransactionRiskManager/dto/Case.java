package com.mthree.FraudAndTransactionRiskManager.dto;

import java.time.LocalDateTime;

//unfinished
public class Case {

    // Case lifecycle statuses
    public static final String OPEN = "OPEN";
    public static final String UNDER_INVESTIGATION = "UNDER_INVESTIGATION";
    public static final String ESCALATED = "ESCALATED";
    public static final String CLOSED_SAFE = "CLOSED_SAFE";
    public static final String CLOSED_FRAUD = "CLOSED_FRAUD";

    private int caseId;
    private int accountId;

    private String status;
    private String priority;
    private int score;
    private LocalDateTime openedAt;
    private LocalDateTime closedAt;

    public int getCaseId() { return caseId; }
    public void setCaseId(int caseId) { this.caseId = caseId; }

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public LocalDateTime getOpenedAt() { return openedAt; }
    public void setOpenedAt(LocalDateTime openedAt) { this.openedAt = openedAt; }

    public LocalDateTime getClosedAt() { return closedAt; }
    public void setClosedAt(LocalDateTime closedAt) { this.closedAt = closedAt; }
}

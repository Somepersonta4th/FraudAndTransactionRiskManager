package com.mthree.FraudAndTransactionRiskManager.dao;

public interface AuditDao {
    public void writeToAudit(String auditLog);
}

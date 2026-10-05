package com.mthree.FraudAndTransactionRiskManager.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CaseTransactionDaoImpl implements CaseTransactionDao{

    private final JdbcTemplate jdbcTemplate;

    public CaseTransactionDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addTransactionToCase(int caseId, int transactionId, String role) {

    }

    @Override
    public boolean isTransactionInCase(int caseId, int transactionId) {
        return false;
    }

    @Override
    public List<CaseTransactionDao> findTransactionsByCaseId(int caseId) {
        return List.of();
    }
}

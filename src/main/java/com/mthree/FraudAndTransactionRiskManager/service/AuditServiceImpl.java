package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dao.AuditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    AuditDao auditDao;

    @Override
    public void writeToAudit(String auditLog) {
        /*
        * audit logging feature option
        auditDao.writeToAudit(auditLog);
         */
    }
}

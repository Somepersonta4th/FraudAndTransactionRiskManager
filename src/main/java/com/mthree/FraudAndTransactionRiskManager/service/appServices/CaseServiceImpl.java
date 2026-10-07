package com.mthree.FraudAndTransactionRiskManager.service.appServices;

import com.mthree.FraudAndTransactionRiskManager.dao.CaseDao;
import com.mthree.FraudAndTransactionRiskManager.dto.Case;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    CaseDao caseDao;

    @Autowired
    TransactionService transactionService;

    @Override
    public Case getCase(int caseID) {
        return caseDao.findCaseById(caseID);
    }

    @Override
    public Case setCaseScore(int caseID, int score) {
        if (caseDao.findCaseById(caseID) == null) {
            return null;
        }
        caseDao.updateCaseScore(caseID, score);
        return caseDao.findCaseById(caseID);
    }

    @Override
    public Case addCaseForAccount(String accountID) {
        Case newCase = new Case();
        newCase.setAccountId(accountID);
        newCase.setStatus(Case.OPEN);
        newCase.setScore(0);
        newCase.setDescription("");
        LocalDateTime localTime = LocalDateTime.now();
        newCase.setOpenedAt(DateTimeFormatter.ISO_LOCAL_DATE.format(localTime) + " " + DateTimeFormatter.ISO_LOCAL_TIME.format(localTime));

        return caseDao.createCase(newCase);
    }

    @Override
    public List<Case> getCasesForAccount(String accountID) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Transactional
    public Case createCase(Case newCase) {
        return caseDao.createCase(newCase);
    }

    @Override
    public List<Case> getCases() {
        return caseDao.findAllCases();
    }

    @Override
    public Case updateCase(Case updatedCase) {
        if (caseDao.findCaseById(updatedCase.getCaseId()) == null) {
            return null;
        }
        caseDao.updateCase(updatedCase);
        return caseDao.findCaseById(updatedCase.getCaseId());
    }

    @Override
    @Transactional
    public void deleteCase(int caseID) {
        caseDao.deleteTransactionsFromCase(caseID);
        caseDao.deleteCase(caseID);
    }

    @Override
    public Case addTransactionToCase(Case aCase, Transaction transaction) {
        List<Transaction> transactions = aCase.getTransactions();
        transactions.add(transaction);
        aCase.setTransactions(transactions);
        return aCase;
    }

    @Override
    public Case setCaseDescription(int caseID, String description) {
        Case aCase = caseDao.findCaseById(caseID);
        if (aCase == null) {
            return null;
        }
        aCase.setDescription(description);
        return null;
    }

}

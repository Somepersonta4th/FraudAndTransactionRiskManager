package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dao.TransactionDao;
import com.mthree.FraudAndTransactionRiskManager.dto.RiskFlag;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import com.mthree.FraudAndTransactionRiskManager.dto.wrappers.TransactionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
//unfinished
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private SearchService searchService;

    @Autowired
    private RiskService riskService;

    private final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public TransactionServiceImpl(TransactionDao transactionDao, SearchService searchService) {
        this.transactionDao = transactionDao;
        this.searchService = searchService;
    }

    @Override
    public void updateTransactions() {
        transactionDao.updateTransactions();
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactionDao.getTransactions();
    }

    @Override
    public Transaction getTransaction(String transactionID) {
        return transactionDao.findTransactionById(transactionID);
    }

    @Override
    public TransactionWrapper getTransactionInfo(String transactionID) {
        TransactionWrapper wrapper = new TransactionWrapper();

        wrapper.setTransaction(getTransaction(transactionID));
        if (wrapper.getTransaction() == null) {
            //return with null contents
            return wrapper;
        }

        wrapper.setRiskFlags(getRiskFlagsForTransaction(transactionID));

        return wrapper;
    }

    @Override
    public List<RiskFlag> getRiskFlagsForTransaction(String transactionID) {
        return riskService.getRiskFlagForTransaction(transactionID);
    }

    /*
    search format:
    terms are space deliminated
    all fields are searched if no field is specified for the term
    field specific search terms = field:value
    values beginning with * are fuzzy searched
    results are intersection of terms
     */
    @Override
    public List<Transaction> searchTransactions(String searchString) {
        return searchTransactions(searchString,getTransactions());
    }

    @Override
    public List<Transaction> searchTransactions(String searchString, List<Transaction> transactions) {
        return (List<Transaction>) searchService.searchObjectsBy(searchString, transactions);
    }

    @Override
    public List<Transaction> getTransactionsForAccount(String accountID) {
        return transactionDao.findTransactionsByAccountId(accountID);
    }


}

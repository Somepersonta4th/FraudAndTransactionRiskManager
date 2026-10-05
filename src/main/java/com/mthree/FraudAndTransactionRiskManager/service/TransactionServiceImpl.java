package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dao.TransactionDao;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
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

    private final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public TransactionServiceImpl(TransactionDao transactionDao, SearchService searchService) {
        this.transactionDao = transactionDao;
        this.searchService = searchService;
    }

    @Override
    public void updateTransactions() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Transaction> getTransactions() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Transaction getTransaction(int transactionID) {
        throw new UnsupportedOperationException();
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
        return searchTransactions(searchString,transactionDao.getTransactions());
    }

    @Override
    public List<Transaction> searchTransactions(String searchString, List<Transaction> transactions) {
        return (List<Transaction>) searchService.searchObjectsBy(searchString, transactions);
    }


}

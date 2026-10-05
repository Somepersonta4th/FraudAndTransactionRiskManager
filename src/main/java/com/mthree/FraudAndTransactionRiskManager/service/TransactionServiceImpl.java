package com.mthree.FraudAndTransactionRiskManager.service;

import com.mthree.FraudAndTransactionRiskManager.dao.TransactionDao;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import info.debatty.java.stringsimilarity.NormalizedLevenshtein;
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


    /*
    * fuzzy mapping with replacing terms

    private static final Map<String,List<String>> fuzzyMapping = new HashMap<>();

    static {
        registerFuzzyMapping("l","1");
        registerFuzzyMapping("e","3");
        registerFuzzyMapping("s","5");
        registerFuzzyMapping("i","y");
        registerFuzzyMapping("inc","corp");
        registerFuzzyMapping("inc","ltd");
        registerFuzzyMapping("inc","co");
        registerFuzzyMapping("inc","llc");
    }

    private static void registerFuzzyMapping(String value1, String value2) {
        fuzzyMapping.computeIfAbsent(value1,k->new ArrayList<>()).add(value2);
        fuzzyMapping.computeIfAbsent(value2,k->new ArrayList<>()).add(value1);
    }

     */

    public TransactionServiceImpl(TransactionDao transactionDao, SearchService searchService) {
        this.transactionDao = transactionDao;
        this.searchService = searchService;
    }

    @Override
    public void updateTransactions() {

    }

    @Override
    public List<Transaction> getTransactions() {
        return List.of();
    }

    @Override
    public Transaction getTransaction(int transactionID) {
        return null;
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

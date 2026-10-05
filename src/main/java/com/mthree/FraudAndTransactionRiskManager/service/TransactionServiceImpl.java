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

    private final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final NormalizedLevenshtein LEVENSHTEIN = new NormalizedLevenshtein();
    private final double LEVENSHTEIN_THRESHOLD = 0.75;

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

    public TransactionServiceImpl(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
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
        if (searchString == null || searchString.trim().isEmpty() || searchString.trim().equals("*"))
        {
            return transactions;
        }
        String[] terms = searchString.toLowerCase(Locale.ROOT).split(" ");

        for (String term : terms) {

            String[] fieldValue = term.split(":");

            if (fieldValue.length == 2){
                // search one field and refine results
                transactions = searchTransactionsByTerm(fieldValue[1],transactions,fieldValue[0]);
            } else {
                // search all field and refine results
                transactions = searchTransactionsByTerm(term,transactions);
            }

        }

        return transactions;
    }

    // search all fields
    private List<Transaction> searchTransactionsByTerm(String searchTerm,List<Transaction> transactions) {
        // if fuzzy search
        if (searchTerm.startsWith("*")) {
            List<Transaction> results = new ArrayList<>();
            searchTerm = searchTerm.substring(1);
            for (Transaction transaction : transactions) {
                if (doesTransactionContainFuzzy(transaction,searchTerm)) {
                    results.add(transaction);
                }
            }
            return results;
        }

        // not fuzzy search with empty field
        return searchTransactionsByTerm(searchTerm,transactions,"");
    }

    // search given field
    private List<Transaction> searchTransactionsByTerm(String searchTerm,List<Transaction> transactions, String field) {
        List<Transaction> results = new ArrayList<>();

        // if fuzzy search
        if (searchTerm.startsWith("*")) {
            searchTerm = searchTerm.substring(1);
            for (Transaction transaction : transactions) {
                if (doesTransactionContainFuzzy(transaction,searchTerm,field)) {
                    results.add(transaction);
                }
            }
            return results;
        }

        // not fuzzy
        for (Transaction transaction : transactions) {
            if (doesTransactionContain(transaction,searchTerm,field)) {
                results.add(transaction);
            }
        }

        return results;
    }

    private boolean doesTransactionContainFuzzy(Transaction transaction, String value) {
        String cleanTransaction = transaction.toStringRaw().toLowerCase(Locale.ROOT);
        String term = value.toLowerCase(Locale.ROOT);

        // perfect match
        if (cleanTransaction.contains(term)) {
            return true;
        }

        // slide window of length value over each word
        int windowSize = term.length();
        String[] words = cleanTransaction.split(" ");
        return Arrays.stream(cleanTransaction.split(" "))
                .anyMatch( word -> {
                    for (int i = 0; i <= word.length() - windowSize; i++) {
                        String chunk = word.substring(i,i + windowSize);
                        if (LEVENSHTEIN.distance(chunk, term) <= LEVENSHTEIN_THRESHOLD){
                            return true;
                        }
                    }
                    return false;
                });


    }

    private boolean doesTransactionContainFuzzy(Transaction transaction, String value, String field) {
        // cut transaction down to relevant field
        String[] transactionFields = transaction.toString().toLowerCase(Locale.ROOT).split(" ");
        for (String transactionField : transactionFields) {
            if (transactionField.startsWith(field)) {
                //target field

                String data = transactionField.split("=")[1];
                String term = value.toLowerCase(Locale.ROOT);

                // perfect match
                if (data.contains(term)) {
                    return true;
                }

                // sliding search window
                for (int i = 0; i <= data.length() - term.length(); i++) {
                    String chunk = data.substring(i,i + term.length());
                    if (LEVENSHTEIN.distance(chunk,term) <= LEVENSHTEIN_THRESHOLD){
                        return true;
                    }
                }

                // not in target field
                return false;
            }
        }

        // no such field
        return false;
    }

    //check if object contains value in any field
    private boolean doesTransactionContain(Transaction transaction, String value) {
        // check with empty field
        return doesTransactionContain(transaction,value,"");
    }

    //check if object contains value at given field
    private boolean doesTransactionContain(Transaction transaction, String value, String field) {
        Boolean doesContain = false;

        doesContain = transaction.toString().toLowerCase(Locale.ROOT).replace("'","").contains(field + "=" + value);

        return doesContain;

    }

}

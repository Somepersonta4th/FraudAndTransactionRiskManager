package com.mthree.FraudAndTransactionRiskManager.service.appServices;

import com.mthree.FraudAndTransactionRiskManager.dao.TransactionDao;
import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    private final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public TransactionServiceImpl(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
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
    public List<Transaction> getTransactionsForAccount(String accountID) {
        return transactionDao.findTransactionsByAccountId(accountID);
    }

    @Override
    public Map<String,List<Transaction>> getTransactionForWeek() {
        // transactions in past 7 days
        return getTransactionInPastDays(7);
    }

    @Override
    public List<Transaction> getTransactionForDay() {
        // transactions in past 24 hours
        return getTransactionInPastHours(24);
    }

    private Map<String,List<Transaction>> getTransactionInPastDays(int days) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Transaction> transactions = getTransactions();
        Map<String,List<Transaction>> map = new HashMap<>();

        // get date of each transaction
        for (Transaction transaction : transactions) {
            LocalDate date = transaction.getDateTransaction();
            date.format(formatter);
            long diff = ChronoUnit.DAYS.between(date,currentDate);
            if (diff<days) {
                map.computeIfAbsent(date.format(formatter), k -> new ArrayList<>()).add(transaction);
            }
        }
        return map;
    }

    private List<Transaction> getTransactionInPastHours(int hours) {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Transaction> transactions = getTransactions();
        List<Transaction> list = new ArrayList<>();

        // get date of each transaction
        for (Transaction transaction : transactions) {
            // sets transaction time to end of day
            LocalDateTime date = transaction.getDateTransaction().atTime(LocalTime.MAX);
            date.format(formatter);
            long diff = ChronoUnit.HOURS.between(date,currentDate);
            if (diff<hours) {
                list.add(transaction);
            }
        }
        return list;
    }


}

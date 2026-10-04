package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.DataSource;

import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;






public class TransactionDaoImpl implements TransactionDao{
    MysqlDataSource ds;

    public TransactionDaoImpl() throws SQLException {
        ds = DataSource.getDataSource();
    }

    @Override
    public ArrayList<Transaction> getTransactions(){
        ArrayList<Transaction> transactions = new ArrayList<>();

        try ( Connection conn = ds.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM transactions");
            while (rs.next()) {
                Transaction temp = new Transaction();

                temp.setId(rs.getString("id"));
                temp.setAccountId(rs.getString("account_id"));
                temp.setAmount(rs.getString("amount"));
                temp.setCurrencyCode(rs.getString("iso_currency_code"));
                temp.setDescription(rs.getString("description"));
                temp.setPrimaryCategory(rs.getString("primary_category"));
                temp.setDetailedCategory(rs.getString("detailed_category"));
                temp.setChannel(rs.getString("payment_channel"));
                temp.setDateTransaction(rs.getString("date_transaction"));
                temp.setDateAuthorised(rs.getString("date_authorised"));
                temp.setCity(rs.getString("city"));
                temp.setCountry(rs.getString("country"));
                temp.setPending(rs.getString("pending").equals("true"));
                transactions.add(temp);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return transactions;
    }
}

package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.DataSource;
import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    MysqlDataSource ds;

    public AccountDaoImpl() throws SQLException {
        ds = DataSource.getDataSource();
    }

    @Override
    public ArrayList<Account> getAccounts(){
        ArrayList<Account> accounts = new ArrayList<>();

        try ( Connection conn = ds.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM accounts");
            while (rs.next()) {
                Account temp = new Account();

                temp.setId(rs.getString("id"));
                temp.setAvailable(rs.getString("available"));
                temp.setCurrent("current");
                temp.setName(rs.getString("account_name"));
                temp.setCurrencyCode(rs.getString("iso_currency_code"));
                temp.setMask(rs.getString("mask"));
                temp.setType(rs.getString("account_type"));
                temp.setSubType(rs.getString("account_subtype"));
                accounts.add(temp);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accounts;
    }

    @Override
    public Account findAccountById(String accountId) {

        System.out.println("HEHEHEHEH");
        return null;
    }



    @Override
    public void updateAccounts() {

    }
}

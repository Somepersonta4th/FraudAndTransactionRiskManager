package com.mthree.FraudAndTransactionRiskManager.dao;

import com.mthree.FraudAndTransactionRiskManager.DataSource;
import com.mthree.FraudAndTransactionRiskManager.dao.Mappers.AccountMapper;
import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoJDBC implements AccountDao{
    private final JdbcTemplate jdbc;

    public AccountDaoJDBC(JdbcTemplate j) throws SQLException {
        jdbc = j;
    }

    @Override
    public List<Account> getAccounts(){
        return jdbc.query("SELECT * FROM Accounts", new AccountMapper());
    }

    @Override
    public Account findAccountById(String accountId) {
        return jdbc.query("SELECT * FROM Accounts WHERE id = " + accountId + ";", new AccountMapper()).get(0);
    }



    @Override
    public void updateAccounts() {

    }
}

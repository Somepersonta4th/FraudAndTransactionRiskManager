package com.mthree.FraudAndTransactionRiskManager.dao.Mappers;

import com.mthree.FraudAndTransactionRiskManager.dto.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account temp = new Account();

        temp.setId(rs.getString("id"));
        temp.setAvailable(rs.getString("available"));
        temp.setCurrent("current");
        temp.setName(rs.getString("account_name"));
        temp.setCurrencyCode(rs.getString("iso_currency_code"));
        temp.setMask(rs.getString("mask"));
        temp.setType(rs.getString("account_type"));
        temp.setSubType(rs.getString("account_subtype"));
        return temp;
    }
}

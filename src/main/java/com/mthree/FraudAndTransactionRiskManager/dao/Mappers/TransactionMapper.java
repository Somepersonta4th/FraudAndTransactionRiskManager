package com.mthree.FraudAndTransactionRiskManager.dao.Mappers;

import com.mthree.FraudAndTransactionRiskManager.dto.Transaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionMapper implements RowMapper<Transaction> {

    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
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
        temp.setPending(rs.getBoolean("pending"));

        temp.setMerchantName(rs.getString("merchant_name"));
        temp.setMerchantEntityId(rs.getString("merchant_entity_id"));
        temp.setMerchantCategoryCode(rs.getString("merchant_category_code"));

        return temp;
    }
}

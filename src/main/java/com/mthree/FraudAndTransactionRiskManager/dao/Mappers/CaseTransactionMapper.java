package com.mthree.FraudAndTransactionRiskManager.dao.Mappers;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaseTransactionMapper implements RowMapper<List<String>> {

    //get 0 for case, 1 for transaction
    @Override
    public List<String> mapRow(ResultSet rs, int rowNum) throws SQLException {
        ArrayList<String> l = new ArrayList<>();
        l.add(rs.getString("case_id"));
        l.add(rs.getString("transaction_id"));
        return l;
    }
}
